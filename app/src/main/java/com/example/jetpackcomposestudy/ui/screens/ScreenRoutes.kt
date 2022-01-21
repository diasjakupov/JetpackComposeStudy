package com.example.jetpackcomposestudy.ui.screens

sealed class ScreenRoutes(val route:String){
    object MainScreen: ScreenRoutes(route = "main_screen")
}
