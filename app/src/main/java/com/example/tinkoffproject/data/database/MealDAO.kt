package com.example.tinkoffproject.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealDAO {
    @Insert
    fun insert(meal: Meal)

    @Query("SELECT * FROM meal")
    fun getAll(): List<Meal>
}