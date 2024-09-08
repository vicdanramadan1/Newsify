package com.example.newsify.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsify.R
import com.example.newsify.domain.usecases.appentry.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingScreenViewModel  @Inject constructor(
    private val saveAppEntry: SaveAppEntry
):  ViewModel() {

    private val _pages = mutableListOf<OnBoardingPageModel>()

    val pages = _pages

    init {
        _pages.add(
            OnBoardingPageModel(
                title = "Discover What Matters",
                description = "Stay updated with the latest headlines and breaking news tailored to your interests.",
                image = R.drawable.onboarding_page_img_1
            )
        )
        _pages.add(
            OnBoardingPageModel(
                title = "Customize Your Feed",
                description = "Choose your favorite topics, sources, and regions to get news that matters to you.",
                image = R.drawable.onboarding_page_img_1
            )
        )
        _pages.add(
            OnBoardingPageModel(
                title = "Stay Informed Anytime",
                description = "Get real-time updates and notifications, so you’re always in the loop.",
                image = R.drawable.onboarding_page_img_1
            )
        )
    }
    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            OnBoardingEvent.SaveAppEntry -> {
                viewModelScope.launch {
                    saveAppEntry.invoke()
                }
            }
        }
    }

}