package com.example.tinkoffproject.domain.useCases.dinner

import com.example.tinkoffproject.data.repository.MealDinnerRepository
import javax.inject.Inject

class GetAllMealDinnerUseCase @Inject constructor(
    private val mealDinnerRepository: MealDinnerRepository
) {
    suspend fun executeProtein(): String {
        return mealDinnerRepository.getAll().sumOf { it.protein }.toString()
    }

    suspend fun executeFat(): String {
        return mealDinnerRepository.getAll().sumOf { it.fat }.toString()
    }

    suspend fun executeCarbohydrates(): String {
        return mealDinnerRepository.getAll().sumOf { it.carbohydrates }.toString()
    }

    suspend fun executeCalories(): String {
        return mealDinnerRepository.getAll().sumOf { it.calories }.toString()
    }
}