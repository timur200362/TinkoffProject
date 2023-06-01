package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import com.example.tinkoffproject.data.repository.MealNightDinnerRepository
import javax.inject.Inject

class GetFavouriteByIdMealNightDinnerUseCase @Inject constructor(
    private val mealNightDinnerRepository: MealNightDinnerRepository
) {
    suspend fun execute(id: Double): MealNightDinner {
        return mealNightDinnerRepository.getFavouriteById(id)
    }
}