package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class GetFavouriteByIdMealNightDinnerUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
){
    suspend fun execute(id:Double):MealBreakfast{
        return mealBreakfastRepository.getFavouriteById(id)
    }
}