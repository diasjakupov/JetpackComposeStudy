package com.example.jetpackcomposestudy.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackcomposestudy.data.db.Database
import com.example.jetpackcomposestudy.data.db.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "App_Database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(database: Database):TaskDao{
        return database.TaskDao()
    }
}