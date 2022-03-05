package com.example.jetpackcomposestudy.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposestudy.data.db.models.Task
import com.example.jetpackcomposestudy.data.repository.TaskRepository
import com.example.jetpackcomposestudy.ui.tasks.TaskListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): ViewModel(){

    private var _taskList = MutableStateFlow<TaskListViewState>(TaskListViewState.LoadingState)
    val taskListState: StateFlow<TaskListViewState> = _taskList


    suspend fun getTaskList(){
      taskRepository.getTaskList().collect {
        _taskList.value=TaskListViewState.DisplayState(it)
      }
    }

    fun insertNewTask(title: String, date:Int, content: String){
        viewModelScope.launch(Dispatchers.IO){
            taskRepository.insertNewTask(Task(title, date, content))
        }
    }
}