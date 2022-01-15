package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.ui.theme.Shapes
import com.example.jetpackcomposestudy.ui.theme.Typography

@Composable
fun CommentItem(nickname: String, comment: String, imageBitmap: Painter){
    Surface(shape = Shapes.medium, modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.surface)
        ) {
        Row() {
            Image(painter = imageBitmap,
                contentDescription = "User Photo",
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
                    .size(35.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Black, CircleShape)

                        )
            Column(modifier = Modifier.padding(start = 10.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)) {
                Text(text = nickname,
                    style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp))
                Text(text = comment, style = Typography.body1, maxLines = 5, overflow = TextOverflow.Ellipsis)
            }
            

        }

    }
}

@Composable
@Preview
fun PreviewCommentItem(){
    CommentItem("John Doe",
        "I love Jetpack Compose",
        painterResource(id = R.drawable.ic_launcher_background))
}