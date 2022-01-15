package com.example.jetpackcomposestudy.ui.theme

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposestudy.ui.elements.DetailScreen
import com.example.jetpackcomposestudy.ui.elements.MyApp
import com.example.jetpackcomposestudy.ui.models.PostItemModel
import com.example.jetpackcomposestudy.ui.models.ScreenRoutes

@ExperimentalMaterialApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(route = ScreenRoutes.MainScreen.route, arguments = listOf(navArgument("post"){type=
            NavType.ParcelableType(PostItemModel::class.java)})){
            MyApp(){item->
                navController.navigate(ScreenRoutes.DetailScreen.withArgs(item))
            }
        }
        composable(route = ScreenRoutes.DetailScreen.route + "/{post}"){
            Log.e("TAG", "${it.arguments?.getString("post")}")
            it.arguments?.getParcelable<PostItemModel>("post")?.let { it1 -> DetailScreen(it1) }
        }
    }
}