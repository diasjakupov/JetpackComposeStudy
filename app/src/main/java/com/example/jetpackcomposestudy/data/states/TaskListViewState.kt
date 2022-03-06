package com.example.jetpackcomposestudy.data.states

import com.example.jetpackcomposestudy.data.db.models.Task

sealed class TaskListViewState {
    object LoadingState: TaskListViewState()
    class DisplayState(val taskList: List<Task>): TaskListViewState()
    object ItemsNotFound: TaskListViewState()
}