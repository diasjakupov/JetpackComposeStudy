package com.example.jetpackcomposestudy.ui.elements

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposestudy.ui.screens.ScreenRoutes


@Composable
fun Drawer(navHostController: NavHostController) {
    val pagesLink = arrayListOf(
        "My Tasks" to "main_screen",
        "Notes" to "notes_screen",
        "Completed tasks" to "completed_screen",
    )

    var currentPage by remember {
        mutableStateOf(navHostController.currentBackStackEntry?.destination?.route)
    }
    Surface(
        modifier = Modifier
            .width(240.dp)
            .fillMaxHeight(),
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight()
        )
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(24.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(125.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Person Icon",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .size(80.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Dias Jakupov", style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Location icon")
                Text(text = "Pavlodar, Kazakhstan", style = MaterialTheme.typography.subtitle2)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column() {
                pagesLink.forEach {
                    Text(
                        it.first,
                        style = if (it.second == currentPage) MaterialTheme.typography.h6 else MaterialTheme.typography.body1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 3.dp, bottom = 3.dp)
                            .clickable {
                                navHostController.navigate(it.second)
                                currentPage = it.second
                            }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Create Task")
                }
            }
        }
    }
}


fun drawerCustomShape(width: Float): Shape {
    return object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            return Outline.Rectangle(Rect(left = 0f, top = 0f, right = width, bottom = size.height))
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    Drawer(rememberNavController())
}