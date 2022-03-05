package com.example.jetpackcomposestudy.data.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposestudy.data.db.TaskDatabase
import com.example.jetpackcomposestudy.data.db.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): TaskDatabase {

        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "app_Database"
        ).build()
    }



    @Provides
    @Singleton
    fun provideTaskDao(database: TaskDatabase): TaskDao {
        return database.TaskDao()
    }
}