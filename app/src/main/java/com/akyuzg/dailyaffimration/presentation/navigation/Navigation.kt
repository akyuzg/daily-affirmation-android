package com.akyuzg.dailyaffimration.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akyuzg.dailyaffimration.presentation.Screen
import com.akyuzg.dailyaffimration.presentation.loginregister.LoginRegisterScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginRegister.route) {
        composable(route = Screen.LoginRegister.route) {
            LoginRegisterScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Deneme"
                    nullable = true
                }
            )
        ) { entry ->
          // DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}





