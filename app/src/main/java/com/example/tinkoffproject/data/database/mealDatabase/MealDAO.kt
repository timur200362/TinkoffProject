package com.example.tinkoffproject.data.database.mealDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealDAO {
    //Breakfast
    @Insert
    suspend fun insert(mealBreakfast: MealBreakfast)

    @Query("SELECT * FROM MealBreakfast")
    suspend fun getAll(): List<MealBreakfast>

    @Query("UPDATE MealBreakfast SET isFavourite=:isFavourite WHERE foodId=:id")
    suspend fun updateFavourite(isFavourite: Boolean, id: Double)

    @Query("SELECT * FROM MealBreakfast WHERE isFavourite=true")
    suspend fun getFavourite(): List<MealBreakfast>

    @Query("SELECT * FROM MealBreakfast WHERE foodId=:id")
    suspend fun getFavouriteById(id: Double): MealBreakfast

    //Dinner
    @Insert
    suspend fun insertDinner(mealDinner: MealDinner)

    @Query("SELECT * FROM MealDinner")
    suspend fun getAllDinner(): List<MealDinner>

    @Query("UPDATE MealDinner SET isFavourite=:isFavourite WHERE foodId=:id")
    suspend fun updateFavouriteDinner(isFavourite: Boolean, id: Double)

    @Query("SELECT * FROM MealDinner WHERE isFavourite=true")
    suspend fun getFavouriteDinner(): List<MealDinner>

    @Query("SELECT * FROM MealDinner WHERE foodId=:id")
    suspend fun getFavouriteByIdDinner(id: Double): MealDinner
}