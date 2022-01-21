package com.example.jetpackcomposestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposestudy.ui.elements.TopBar
import com.example.jetpackcomposestudy.ui.navigation.Navigation
import com.example.jetpackcomposestudy.ui.theme.*

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    private lateinit var navController:NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController= rememberNavController()
            JetpackComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopBar()
                    }
                ) {
                    
                }
                Navigation(navController)
            }
        }
    }
}

