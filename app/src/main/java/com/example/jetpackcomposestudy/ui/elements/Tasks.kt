package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import com.example.jetpackcomposestudy.data.db.models.Task
import com.example.jetpackcomposestudy.ui.theme.*

@ExperimentalAnimationApi
@Composable
fun Tasks(tasks: List<Task>) {
    val taskColors = listOf(
        lightBlue to lightBlueBorder,
        lightGreen to lightGreenBorder,
        lightPink to lightPinkBorder,
        lightYellow to lightYellowBorder
    )

    var idxForColor = 0
    LazyColumn() {
        items(tasks.size) {
            TaskItem(
                task = tasks[it],
                bg = taskColors[idxForColor].first,
                borderColor = taskColors[idxForColor].second
            )
            if (idxForColor < 3) {
                idxForColor++
            } else {
                idxForColor = 0
            }
        }
    }
}
