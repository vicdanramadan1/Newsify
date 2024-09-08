package com.example.newsify.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    pageSize: Int,
    selectedPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        repeat(pageSize){ page ->
            Box(modifier = Modifier
                .padding(4.dp)
                .size(10.dp)
                .clip(CircleShape)
                .background(if (page == selectedPage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(.5f))
            )
        }
    }
}