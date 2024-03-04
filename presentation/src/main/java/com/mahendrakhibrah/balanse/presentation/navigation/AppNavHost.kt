package com.mahendrakhibrah.balanse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mahendrakhibrah.balanse.presentation.features.auth.pages.LoginOrRegisterPage
import com.mahendrakhibrah.balanse.presentation.features.auth.pages.OnboardPage
import com.mahendrakhibrah.balanse.presentation.features.auth.pages.SplashPage

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppRoute.Splash.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppRoute.Splash.route) { SplashPage(navController) }
        composable(AppRoute.Onboard.route) { OnboardPage(navController = navController) }
        composable(AppRoute.LoginOrRegister.route) { LoginOrRegisterPage() }
    }
}