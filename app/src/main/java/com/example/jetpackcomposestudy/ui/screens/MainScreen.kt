package com.example.jetpackcomposestudy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.ui.elements.Search
import com.example.jetpackcomposestudy.ui.elements.TaskItem
import com.example.jetpackcomposestudy.ui.elements.Tasks

@Composable
fun MainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Search()
        Tasks()
    }
}


@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}