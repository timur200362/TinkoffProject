package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.repository.MealNightDinnerRepository
import javax.inject.Inject

class UpdateFavouriteMealNightDinnerUseCase @Inject constructor(
    private val mealNightDinnerRepository: MealNightDinnerRepository
) {
    suspend fun execute(isFavourite: Boolean, id: Double) {
        mealNightDinnerRepository.updateFavourite(isFavourite, id)
    }
}