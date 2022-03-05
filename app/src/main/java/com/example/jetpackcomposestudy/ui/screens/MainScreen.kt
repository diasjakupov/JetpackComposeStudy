package com.example.jetpackcomposestudy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.data.viewmodels.TaskViewModel
import com.example.jetpackcomposestudy.ui.elements.Search
import com.example.jetpackcomposestudy.ui.elements.Tasks
import com.example.jetpackcomposestudy.ui.tasks.TaskListViewState

@Composable
fun MainScreen(viewModel: TaskViewModel) {
    val state = viewModel.taskListState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Search()
        when(state.value){
            is TaskListViewState.LoadingState->{

            }
            is TaskListViewState.DisplayState->{
                Tasks((state.value as TaskListViewState.DisplayState).taskList)
            }
        }
    }

    LaunchedEffect(key1 = true, block = {
        viewModel.getTaskList()
        //TODO(use events)
    })
}


