package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.repository.MealNightDinnerRepository
import javax.inject.Inject

class GetAllMealNightDinnerUseCase @Inject constructor(
    private val mealNightDinnerRepository: MealNightDinnerRepository
) {
    suspend fun executeProtein(): String {
        return mealNightDinnerRepository.getAll().sumOf { it.protein }.toString()
    }

    suspend fun executeFat(): String {
        return mealNightDinnerRepository.getAll().sumOf { it.fat }.toString()
    }

    suspend fun executeCarbohydrates(): String {
        return mealNightDinnerRepository.getAll().sumOf { it.carbohydrates }.toString()
    }

    suspend fun executeCalories(): String {
        return mealNightDinnerRepository.getAll().sumOf { it.calories }.toString()
    }
}