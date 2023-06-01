package com.example.tinkoffproject.data.repository


import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import javax.inject.Inject

class MealNightDinnerRepository @Inject constructor(
    private val mealDatabase: MealDatabase
) {
    suspend fun insert(mealNightDinner: MealNightDinner) =
        mealDatabase.mealDao().insertNightDinner(mealNightDinner)

    suspend fun getAll() = mealDatabase.mealDao().getAllNightDinner()

    suspend fun updateFavourite(isFavourite: Boolean, id: Double) =
        mealDatabase.mealDao().updateFavouriteNightDinner(isFavourite, id)

    suspend fun getFavourite() = mealDatabase.mealDao().getFavouriteNightDinner()
    suspend fun getFavouriteById(id: Double) =
        mealDatabase.mealDao().getFavouriteByIdNightDinner(id)
}