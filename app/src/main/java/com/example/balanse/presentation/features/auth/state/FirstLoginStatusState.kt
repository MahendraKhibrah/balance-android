package com.example.balanse.presentation.features.auth.state

data class FirstLoginStatusState(
    val isFirstLogin: Boolean? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
