package com.mahendrakhibrah.balanse.presentation.navigation

sealed class AppRoute(val route: String){
    object Master: AppRoute("master")

    object Splash: AppRoute("splash")
    object Onboard: AppRoute("onboard")
    object LoginOrRegister: AppRoute("login-or-register")

    fun withArgs(vararg args: Any?): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}