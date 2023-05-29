package com.example.tinkoffproject.domain.useCases.breakfast

import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class AddMealBreakfastUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
) {
    suspend fun execute(mealBreakfast: MealBreakfast){
        mealBreakfastRepository.insert(mealBreakfast)
    }
}