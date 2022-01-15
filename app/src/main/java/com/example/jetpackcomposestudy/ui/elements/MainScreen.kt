package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.ui.models.CommentItemModel
import com.example.jetpackcomposestudy.ui.models.FAKE_DATABASE
import com.example.jetpackcomposestudy.ui.models.PostItemModel
import com.example.jetpackcomposestudy.ui.theme.JetpackComposeStudyTheme

@ExperimentalMaterialApi
@Composable
fun MyApp(showComments: (item: PostItemModel) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        CardList(fakeDataSet = FAKE_DATABASE) {
            showComments(it)
        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 32.dp, end = 28.dp)
        ) {
            Icon(imageVector = Icons.Rounded.FilterAlt, contentDescription = "Filter Icon")
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun MyAppPreview() {
    MyApp() {}
}

