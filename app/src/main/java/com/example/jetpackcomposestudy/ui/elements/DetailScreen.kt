package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.ui.models.CommentItemModel
import com.example.jetpackcomposestudy.ui.models.PostItemModel

@Composable
fun DetailScreen(post: PostItemModel) {
    PostItem(post = post, listOfComments = listOf(CommentItemModel("Dias", "I enjoy coding")))
}