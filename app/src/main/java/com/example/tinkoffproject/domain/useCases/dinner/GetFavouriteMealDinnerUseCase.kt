package com.example.tinkoffproject.domain.useCases.dinner

import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.data.repository.MealDinnerRepository
import javax.inject.Inject

class GetFavouriteMealDinnerUseCase @Inject constructor(
    private val mealDinnerRepository: MealDinnerRepository
) {
    suspend fun execute(): List<MealDinner> {
        return mealDinnerRepository.getFavourite()
    }
}