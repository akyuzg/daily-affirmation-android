package com.akyuzg.dailyaffirmation.common

sealed class Screen(val route: String) {
    object AuthScreen : Screen("auth_screen")
    object ProfileScreen : Screen("profile_screen")
    object AffirmationsScreen : Screen("affirmations_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

