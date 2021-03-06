package com.example.jetpackcomposestudy.data.repository

import com.example.jetpackcomposestudy.data.db.dao.TaskDao
import com.example.jetpackcomposestudy.data.db.models.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    val taskDao: TaskDao
) : TaskRepository {

    override suspend fun getTaskList(): Flow<List<Task>> {
        return taskDao.getTaskList()
    }

    override suspend fun insertNewTask(task: Task) {
        taskDao.insertTask(task)
    }

}