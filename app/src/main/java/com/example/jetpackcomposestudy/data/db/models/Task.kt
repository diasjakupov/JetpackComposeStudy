package com.example.jetpackcomposestudy.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val idx:Int=0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: Int,
    @ColumnInfo(name = "content") val content: String
)
