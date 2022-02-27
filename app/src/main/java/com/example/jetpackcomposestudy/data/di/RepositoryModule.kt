package com.example.jetpackcomposestudy.data.di

import com.example.jetpackcomposestudy.data.db.Database
import com.example.jetpackcomposestudy.data.db.dao.TaskDao
import com.example.jetpackcomposestudy.data.repository.TaskRepository
import com.example.jetpackcomposestudy.data.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideTaskRepository(taskDao: TaskDao):TaskRepository{
        return TaskRepositoryImpl(taskDao = taskDao)
    }
}