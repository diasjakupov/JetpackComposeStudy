package com.example.jetpackcomposestudy.data.states.tasks

import com.example.jetpackcomposestudy.data.db.models.Task

sealed class TaskListViewState {
    object LoadingState: TaskListViewState()
    class DisplayState(val taskList: List<Task>):TaskListViewState()
}