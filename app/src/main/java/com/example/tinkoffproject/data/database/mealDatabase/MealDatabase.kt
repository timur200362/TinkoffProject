package com.example.tinkoffproject.data.database.mealDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tinkoffproject.presentation.Converter

@TypeConverters(Converter::class)
@Database(entities = [MealBreakfast::class], version = 5)
abstract class MealDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDAO

    companion object {
        @Volatile
        private var Instance: MealDatabase? = null
        fun getDatabase(context: Context): MealDatabase {
            val tempInstance = Instance
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MealDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()
                Instance = instance
                return instance
            }
        }
    }
}