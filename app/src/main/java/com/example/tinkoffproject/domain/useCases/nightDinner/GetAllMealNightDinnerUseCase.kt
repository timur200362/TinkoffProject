package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class GetAllMealNightDinnerUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
) {
    suspend fun executeProtein(): String {
        return mealBreakfastRepository.getAll().sumOf { it.protein }.toString()
    }

    suspend fun executeFat(): String {
        return mealBreakfastRepository.getAll().sumOf { it.fat }.toString()
    }

    suspend fun executeCarbohydrates(): String {
        return mealBreakfastRepository.getAll().sumOf { it.carbohydrates }.toString()
    }

    suspend fun executeCalories(): String {
        return mealBreakfastRepository.getAll().sumOf { it.calories }.toString()
    }
}