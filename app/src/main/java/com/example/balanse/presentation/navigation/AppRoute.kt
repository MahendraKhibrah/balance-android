package com.example.balanse.presentation.navigation

sealed class AppRoute(val route: String){
    object Master: AppRoute("master")
    object Detail: AppRoute("detail")
    object Main : AppRoute("main")
    object Setting : AppRoute("setting")
    object Profile : AppRoute("profile")
    object Home : AppRoute("home")

    fun withArgs(vararg args: Any?): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}