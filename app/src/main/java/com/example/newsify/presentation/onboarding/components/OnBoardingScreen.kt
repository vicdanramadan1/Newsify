package com.example.newsify.presentation.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsify.presentation.common.PagerIndicator
import com.example.newsify.presentation.onboarding.OnBoardingEvent
import com.example.newsify.presentation.onboarding.OnBoardingScreenViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onBoardingScreenViewModel: OnBoardingScreenViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val pages = onBoardingScreenViewModel.pages
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) {
            OnBoardingPage(model = pages[it])

        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { onBoardingScreenViewModel.onEvent(OnBoardingEvent.SaveAppEntry) }) {
                Text(text = "Skip", color = MaterialTheme.colorScheme.primary)
            }
            PagerIndicator(pageSize = pages.size, selectedPage = pagerState.currentPage)
            TextButton(onClick = {
                if (pagerState.currentPage < pages.size) {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    onBoardingScreenViewModel.onEvent(OnBoardingEvent.SaveAppEntry)
                }
            }) {
                Text(text = "Next", color = MaterialTheme.colorScheme.primary)
            }

        }
    }
}
