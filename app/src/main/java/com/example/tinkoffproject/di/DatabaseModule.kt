package com.example.tinkoffproject.di

import android.content.Context
import androidx.room.Room
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MealDatabase {
        return Room.databaseBuilder(
            appContext,
            MealDatabase::class.java,
            "app_database"
        ).build()
    }
}