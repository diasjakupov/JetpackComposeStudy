package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import com.example.jetpackcomposestudy.ui.theme.*

@Composable
fun Tasks(){
    var colorCount = 0

    val taskColors = listOf(
        lightBlue to lightBlueBorder,
        lightGreen to lightGreenBorder,
        lightPink to lightPinkBorder,
        lightYellow to lightYellowBorder
    )
    LazyColumn(){
        items(5){
            if (colorCount<3){
                colorCount++
            }else{
                colorCount=0
            }
            val colors = taskColors[colorCount]
            TaskItem(bg = colors.first, borderColor = colors.second)
        }
    }
}

