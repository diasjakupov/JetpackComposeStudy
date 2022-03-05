package com.example.jetpackcomposestudy.data.repository

import com.example.jetpackcomposestudy.data.db.models.Task
import kotlinx.coroutines.flow.Flow


interface TaskRepository {

    suspend fun getTaskList(): Flow<List<Task>>
    suspend fun insertNewTask(task:Task)
}