package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CalendarViewMonth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.data.db.models.Task
import com.example.jetpackcomposestudy.ui.theme.Shapes
import com.example.jetpackcomposestudy.ui.theme.Typography

@ExperimentalAnimationApi
@Composable
fun TaskItem(task: Task, bg: Color?, borderColor: Color?) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(bottom = 20.dp),
        shape = Shapes.large,
        backgroundColor = bg ?: MaterialTheme.colors.background,
        border = BorderStroke(1.dp, borderColor ?: Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp,  end=8.dp, bottom = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(task.title, style = Typography.h6, modifier = Modifier.weight(8f))
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (!expanded) Icons.Default.ArrowDropDown else Icons.Default.ArrowDropUp,
                        contentDescription = "Arrow dropdown",
                        modifier = Modifier
                            .weight(1f)
                            .size(32.dp)
                    )
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = "calendar icon"
                )
                Text(
                    "08 March",
                    style = Typography.body1,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            AnimatedContent(targetState = expanded) { elementExpanded ->
                if (elementExpanded) {
                    Column() {
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        Text(text = task.content, modifier = Modifier.padding(bottom = 8.dp))
                    }
                }

            }

        }

    }

}


