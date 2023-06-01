package com.example.tinkoffproject.domain.useCases.nightDinner

import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import com.example.tinkoffproject.data.repository.MealNightDinnerRepository
import javax.inject.Inject

class GetFavouriteMealNightDinnerUseCase @Inject constructor(
    private val mealNightDinnerRepository: MealNightDinnerRepository
) {
    suspend fun execute(): List<MealNightDinner> {
        return mealNightDinnerRepository.getFavourite()
    }
}