package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import javax.inject.Inject

class UpdateFavouriteMealNightDinnerUseCase @Inject constructor(
    private val mealBreakfastRepository: MealBreakfastRepository
) {
    suspend fun execute(isFavourite: Boolean, id: Double) {
        mealBreakfastRepository.updateFavourite(isFavourite, id)
    }
}