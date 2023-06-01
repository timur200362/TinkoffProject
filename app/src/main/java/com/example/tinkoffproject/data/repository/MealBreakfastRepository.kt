package com.example.tinkoffproject.data.repository


import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import javax.inject.Inject

class MealBreakfastRepository @Inject constructor(
    private val mealDatabase: MealDatabase
) {
    suspend fun insert(mealBreakfast: MealBreakfast) = mealDatabase.mealDao().insert(mealBreakfast)

    suspend fun getAll() = mealDatabase.mealDao().getAll()

    suspend fun updateFavourite(isFavourite: Boolean, id: Double) =
        mealDatabase.mealDao().updateFavourite(isFavourite, id)

    suspend fun getFavourite() = mealDatabase.mealDao().getFavourite()
    suspend fun getFavouriteById(id: Double) = mealDatabase.mealDao().getFavouriteById(id)
}