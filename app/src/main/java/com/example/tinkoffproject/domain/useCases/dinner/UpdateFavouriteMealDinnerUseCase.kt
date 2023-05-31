package com.example.tinkoffproject.domain.useCases.dinner

import com.example.tinkoffproject.data.repository.MealBreakfastRepository
import com.example.tinkoffproject.data.repository.MealDinnerRepository
import javax.inject.Inject

class UpdateFavouriteMealDinnerUseCase @Inject constructor(
    private val mealDinnerRepository: MealDinnerRepository
) {
    suspend fun execute(isFavourite: Boolean, id: Double) {
        mealDinnerRepository.updateFavourite(isFavourite, id)
    }
}