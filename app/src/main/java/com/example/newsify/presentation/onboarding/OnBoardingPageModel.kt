package com.example.newsify.presentation.onboarding

import androidx.annotation.DrawableRes

data class OnBoardingPageModel(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
