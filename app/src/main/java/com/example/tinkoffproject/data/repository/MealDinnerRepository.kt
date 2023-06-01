package com.example.tinkoffproject.data.repository


import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import javax.inject.Inject

class MealDinnerRepository @Inject constructor(
    private val mealDatabase: MealDatabase
) {
    suspend fun insert(mealDinner: MealDinner) = mealDatabase.mealDao().insertDinner(mealDinner)

    suspend fun getAll() = mealDatabase.mealDao().getAllDinner()

    suspend fun updateFavourite(isFavourite: Boolean, id: Double) =
        mealDatabase.mealDao().updateFavouriteDinner(isFavourite, id)

    suspend fun getFavourite() = mealDatabase.mealDao().getFavouriteDinner()
    suspend fun getFavouriteById(id: Double) = mealDatabase.mealDao().getFavouriteByIdDinner(id)
}