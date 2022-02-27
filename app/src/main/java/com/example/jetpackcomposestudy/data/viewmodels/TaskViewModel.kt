package com.example.jetpackcomposestudy.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposestudy.data.db.models.Task
import com.example.jetpackcomposestudy.data.repository.TaskRepository
import com.example.jetpackcomposestudy.data.states.tasks.TaskListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    val taskRepository: TaskRepository
): ViewModel(){

    private var _taskList = MutableStateFlow<TaskListViewState>(TaskListViewState.LoadingState)
    val taskList: StateFlow<TaskListViewState> = _taskList


    suspend fun getTaskList(){
      taskRepository.getTaskList().collect {
        _taskList.value=TaskListViewState.DisplayState(it)
      }
    }
}