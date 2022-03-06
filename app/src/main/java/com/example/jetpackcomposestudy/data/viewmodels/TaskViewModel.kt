package com.example.jetpackcomposestudy.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposestudy.data.db.models.Task
import com.example.jetpackcomposestudy.data.repository.TaskRepository
import com.example.jetpackcomposestudy.data.states.TaskListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): ViewModel(){

    private var _taskList = MutableStateFlow(listOf<Task>())
    private var _taskListState = MutableStateFlow<TaskListViewState>(TaskListViewState.LoadingState)
    val taskListState: StateFlow<TaskListViewState> = _taskListState


    fun getTaskList(){
        viewModelScope.launch(Dispatchers.IO){
            taskRepository.getTaskList().collect {data->
                if(data.isNotEmpty()){
                    _taskList.value=data
                    _taskListState.value = TaskListViewState.DisplayState(data)
                }else{
                    _taskListState.value = TaskListViewState.ItemsNotFound
                }
            }
        }
    }

    fun insertNewTask(title: String, date:Int, content: String){
        viewModelScope.launch(Dispatchers.IO){
            taskRepository.insertNewTask(Task(title, date, content))
        }
    }

    private suspend fun filter(text:String):List<Task>{
        return withContext(Dispatchers.IO){_taskList.value.filter {
            it.title.contains(text)
        }
    }
    }

    fun onSearch(text: String){
        viewModelScope.launch {
            _taskListState.value=TaskListViewState.LoadingState
            delay(100)
            val filteredTaskList=filter(text)
            if (filteredTaskList.isNotEmpty()){
                _taskListState.value=TaskListViewState.DisplayState(filteredTaskList)
            }else{
                _taskListState.value=TaskListViewState.ItemsNotFound
            }
        }
    }
}