package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.ui.models.CommentItemModel
import com.example.jetpackcomposestudy.ui.models.PostItemModel
import com.example.jetpackcomposestudy.ui.theme.Typography

@Composable
fun PostItem(post:PostItemModel, listOfComments: List<CommentItemModel>){
    Surface() {
        Column(modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()) {
            //for post
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "User Photo",
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Black, CircleShape))
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Row() {
                            Text(text = post.author, style= Typography.body1, modifier = Modifier.weight(1f))
                            Text(text = post.date, style = Typography.subtitle2, modifier = Modifier.alpha(0.5f))
                        }
                        Text(text = post.title, style = Typography.h6, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                }
                Text(text = post.text,
                    fontSize = 18.sp,
                    fontStyle = MaterialTheme.typography.body1.fontStyle)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Divider(thickness = 1.dp, color = Color.Gray)
            Column() {
                Text(text = "Comments:")
                LazyColumn(){
                    items(items=listOfComments){
                        CommentItem(nickname = it.author, comment = it.comment, imageBitmap = painterResource(
                            id = R.drawable.ic_launcher_background
                        ))
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewPostItem(){
    PostItem(post=PostItemModel(
        author = "John Doe_",
        title = "Some awesome news #1",
        text = stringResource(id = R.string.lorem_ipsum),
        date = "1 day ago"),
        listOfComments = listOf(CommentItemModel("Dias", "I agree with your opinion that Jetpack Compose is aweesome")))
}