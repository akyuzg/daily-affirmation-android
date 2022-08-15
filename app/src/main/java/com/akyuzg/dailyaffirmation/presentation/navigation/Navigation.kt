package com.akyuzg.dailyaffirmation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akyuzg.dailyaffirmation.common.Screen
import com.akyuzg.dailyaffirmation.presentation.affirmations.AffirmationsScreen
import com.akyuzg.dailyaffirmation.presentation.auth.AuthScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.AuthScreen.route) {
        composable(route = Screen.AffirmationsScreen.route) {
            AffirmationsScreen(navController = navController)
        }
        composable(route = Screen.AuthScreen.route) {
            AuthScreen(navController = navController)
        }
    }
}





