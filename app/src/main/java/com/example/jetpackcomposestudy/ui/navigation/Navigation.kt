package com.example.jetpackcomposestudy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposestudy.ui.screens.MainScreen
import com.example.jetpackcomposestudy.ui.screens.ScreenRoutes

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(route = ScreenRoutes.MainScreen.route) {
            MainScreen()
        }
    }
}