package com.example.tinkoffproject.domain.useCases.breakfast

import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class GetAllMealBreakfastUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
) {
    suspend fun execute(){
        mealBreakfastRepository.getAll()
    }
}