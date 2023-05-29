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

    @Query("UPDATE MealBreakfast SET isFavourite=:isFavourite WHERE foodId=:id")
    suspend fun updateFavorite(isFavourite: Boolean, id: Double)

    @Query("SELECT * FROM MealBreakfast WHERE isFavourite=true")
    suspend fun getFavourite(): List<MealBreakfast>

//    @Query("SELECT * FROM MealBreakfast WHERE foodId=:id") TODO не работает, че то с конструктором
//    suspend fun getFavouriteOnId(id:Double)
}