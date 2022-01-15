package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.ui.models.PostItemModel
import com.example.jetpackcomposestudy.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(data:PostItemModel, onClick: ()->Unit) {
    var expanded by remember { mutableStateOf(true) }
    val rotationState by animateFloatAsState(targetValue = if (expanded) 180f else 0f)

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = FastOutLinearInEasing
            )
        )
        .padding(5.dp)
        .background(MaterialTheme.colors.surface)
        .border(0.5.dp, Color.Black, Shapes.medium),
        shape = Shapes.medium,
        onClick = {
            expanded = !expanded
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = data.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    modifier = Modifier.weight(6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    onClick = {
                        expanded = !expanded
                    }, modifier = Modifier
                        .height(20.dp)
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-down icon",
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            }
            if (expanded) {
                Column() {
                    Text(
                        text = data.text,
                        fontSize = 18.sp,
                        fontStyle = MaterialTheme.typography.body1.fontStyle,
                        maxLines = 6
                    )
                    Row(horizontalArrangement = Arrangement.End,
                        modifier = Modifier.padding(top = 10.dp, end = 10.dp).alpha(0.5f).fillMaxWidth()) {
                        Text(
                            text = "By ${data.author}: ${data.date}",
                            fontSize = 10.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { onClick() }) {
                        Text(
                            text = "Show more",
                            modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp),
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
@Preview
fun PreviewExpandableCard() {
    ExpandableCard(PostItemModel("Dias", "Title test", "test", "2 years ago")){}
}