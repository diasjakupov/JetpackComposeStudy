package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun Drawer() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
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
                Text("DashBoard", style = MaterialTheme.typography.body1)
                Text("Notes", style = MaterialTheme.typography.body1)
                Text("Completed tasks", style = MaterialTheme.typography.body1)
                Button(
                    onClick = { /*TODO*/ },
                    colors=buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
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
    Drawer()
}