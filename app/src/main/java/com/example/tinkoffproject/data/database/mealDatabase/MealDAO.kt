package com.example.tinkoffproject.data.database.mealDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealDAO {
    @Insert
    suspend fun insert(mealBreakfast: MealBreakfast)

    @Query("SELECT * FROM MealBreakfast")
    suspend fun getAll(): List<MealBreakfast>
}