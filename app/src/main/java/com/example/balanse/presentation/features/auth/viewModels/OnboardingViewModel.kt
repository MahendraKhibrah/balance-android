package com.example.balanse.presentation.features.auth.viewModels

import android.content.Context
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
    fun getOnboardItems(context : Context): List<OnboardItem> {
        return listOf(
            OnboardItem(
                context.resources.getString(R.string.welcome_to_balanse),
                context.resources.getString(R.string.welcome_to_balanse_description),
                R.drawable.onboard_item_1,
                BlackPrimary,
                true
            ),
            OnboardItem(
                context.resources.getString(R.string.track_your_expanses),
                context.resources.getString(R.string.track_your_expanses_description),
                R.drawable.onboard_item_2,
                YellowPrimary,
                false
            ),
            OnboardItem(
                context.resources.getString(R.string.manage_your_budget),
                context.resources.getString(R.string.manage_your_budget_description),
                R.drawable.onboard_item_3,
                SoftBlue,
                false
            )
        )
    }
}