package com.example.balanse.presentation.features.auth.viewModels

import androidx.lifecycle.ViewModel
import com.example.balanse.R
import com.example.balanse.common.theme.BlackPrimary
import com.example.balanse.common.theme.SoftBlue
import com.example.balanse.common.theme.YellowPrimary
import com.example.balanse.domain.models.auth.OnboardItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {
    final val onboardItems = listOf(
        OnboardItem(
            "Welcome to Balanse",
            "Balanse is a simple and easy to use app to manage your finances",
            R.drawable.onboard_item_1,
            BlackPrimary,
            true
        ),
        OnboardItem(
            "Track your expenses",
            "Keep track of your expenses and see where your money goes",
            R.drawable.onboard_item_2,
            YellowPrimary,
            false
        ),
        OnboardItem(
            "Plan your budget",
            "Set a budget and make sure you don't overspend",
            R.drawable.onboard_item_3,
            SoftBlue,
            false
        )
    )
}