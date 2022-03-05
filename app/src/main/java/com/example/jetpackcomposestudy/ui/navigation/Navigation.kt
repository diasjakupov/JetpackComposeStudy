package com.example.jetpackcomposestudy.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposestudy.data.viewmodels.TaskViewModel
import com.example.jetpackcomposestudy.ui.screens.MainScreen
import com.example.jetpackcomposestudy.ui.screens.ScreenRoutes

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(route = ScreenRoutes.MainScreen.route) {
            val viewModel= hiltViewModel<TaskViewModel>()
            MainScreen(viewModel)
        }
        composable(route = ScreenRoutes.NotesScreen.route) {
            Text(text = "Notes screen")
        }
        composable(route = ScreenRoutes.CompletedScreen.route) {
            Text(text = "Completed screen")

        }
    }
}