package com.mahendrakhibrah.balanse.domain.models.auth

import androidx.compose.ui.graphics.Color

data class OnboardItem(
    val title: String,
    val description: String,
    val image: Int,
    val color: Color,
    val isDark : Boolean
)

