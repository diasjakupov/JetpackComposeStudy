package com.example.jetpackcomposestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposestudy.ui.elements.Drawer
import com.example.jetpackcomposestudy.ui.elements.TopBar
import com.example.jetpackcomposestudy.ui.elements.drawerCustomShape
import com.example.jetpackcomposestudy.ui.navigation.Navigation
import com.example.jetpackcomposestudy.ui.theme.*

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    private lateinit var navController:NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController= rememberNavController()
            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            JetpackComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopBar(scaffoldState, coroutineScope)
                    },
                    drawerContent = {
                        Drawer()
                    },
                    drawerShape = drawerCustomShape(800f)

                ) {
                    
                }
                Navigation(navController)
            }
        }
    }
}

