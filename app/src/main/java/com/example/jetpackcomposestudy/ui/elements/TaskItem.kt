package com.example.jetpackcomposestudy.ui.elements

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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.data.db.models.Task
import com.example.jetpackcomposestudy.ui.theme.Shapes
import com.example.jetpackcomposestudy.ui.theme.Typography

@Composable
fun TaskItem(task: Task,bg: Color?, borderColor: Color?) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .animateContentSize(animationSpec = tween(300, easing = FastOutSlowInEasing))
            .padding(bottom = 20.dp),
        shape = Shapes.large,
        backgroundColor = bg ?: MaterialTheme.colors.background,
        border = BorderStroke(1.dp, borderColor ?: Color.Gray)
    ) {
        Column(
            modifier = Modifier.padding(8.dp).padding(start = 4.dp)
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

            if (expanded) {
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Column() {
                    Text(text = task.content, modifier = Modifier.padding(bottom = 8.dp))
                }
            }

        }

    }
}

