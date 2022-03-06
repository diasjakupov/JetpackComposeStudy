package com.example.jetpackcomposestudy.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.data.viewmodels.TaskViewModel
import com.example.jetpackcomposestudy.ui.elements.Loader
import com.example.jetpackcomposestudy.ui.elements.Search
import com.example.jetpackcomposestudy.ui.elements.Tasks
import com.example.jetpackcomposestudy.data.states.TaskListViewState

@ExperimentalAnimationApi
@Composable
fun MainScreen(viewModel: TaskViewModel) {
    val state = viewModel.taskListState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Search(state.value){text->
            viewModel.onSearch(text)
        }
        when(state.value){
            is TaskListViewState.LoadingState->{
                Loader()
            }
            is TaskListViewState.DisplayState->{
                Tasks((state.value as TaskListViewState.DisplayState).taskList)
            }
            else -> {}
        }
    }

    LaunchedEffect(key1 = true, block = {
        viewModel.getTaskList()
    })
}


