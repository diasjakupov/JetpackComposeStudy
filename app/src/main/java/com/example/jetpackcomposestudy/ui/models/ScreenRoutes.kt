package com.example.jetpackcomposestudy.ui.models

sealed class ScreenRoutes(val route:String){
    object MainScreen:ScreenRoutes("main_screen")
    object DetailScreen:ScreenRoutes("detail_screen")

    fun withArgs(post:PostItemModel):String{
        return "${route}/${post}"
    }
}
