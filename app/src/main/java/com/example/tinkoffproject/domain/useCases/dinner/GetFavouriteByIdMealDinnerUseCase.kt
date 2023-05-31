package com.example.tinkoffproject.domain.useCases.dinner

import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import com.example.tinkoffproject.data.repository.MealDinnerRepository
import javax.inject.Inject

class GetFavouriteByIdMealDinnerUseCase @Inject constructor(
    private val mealDinnerRepository:MealDinnerRepository
){
    suspend fun execute(id:Double):MealDinner{
        return mealDinnerRepository.getFavouriteById(id)
    }
}