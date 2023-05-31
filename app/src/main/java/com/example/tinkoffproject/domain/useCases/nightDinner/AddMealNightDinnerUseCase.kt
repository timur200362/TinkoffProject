package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class AddMealNightDinnerUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
) {
    suspend fun execute(mealBreakfast: MealBreakfast) {
        mealBreakfastRepository.insert(mealBreakfast)
    }
}