package com.example.tinkoffproject.domain.useCases.breakfast

import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class UpdateFavouriteMealBreakfastUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
) {
    suspend fun execute(isFavourite: Boolean, id: Double) {
        mealBreakfastRepository.updateFavourite(isFavourite, id)
    }
}