package com.example.jetpackcomposestudy.ui.tasks

import com.example.jetpackcomposestudy.data.db.models.Task

sealed class TaskListViewState {
    object LoadingState: TaskListViewState()
    class DisplayState(val taskList: List<Task>):TaskListViewState()
}