package com.example.tinkoffproject.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tinkoffproject.presentation.Converter

@TypeConverters(Converter::class)
@Database(entities = [Meal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDAO

    companion object{
        @Volatile
        private var Instance:AppDatabase?=null

        fun getDatabase(context: Context):AppDatabase{
            val tempInstance= Instance
            if (tempInstance!=null) return tempInstance
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                Instance=instance
                return instance
            }
        }
    }
}