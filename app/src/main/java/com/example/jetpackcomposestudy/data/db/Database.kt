package com.example.jetpackcomposestudy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomposestudy.data.db.dao.TaskDao
import com.example.jetpackcomposestudy.data.db.models.Task


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun TaskDao(): TaskDao
}