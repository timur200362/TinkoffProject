package com.example.tinkoffproject.domain.useCases

import com.example.tinkoffproject.data.repository.FoodRepository
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import javax.inject.Inject

class GetProductTitleUseCase @Inject constructor(
    private val foodRepository: FoodRepository
) {
    suspend fun execute(foodId: Int): ProductFilter {
        foodRepository.getFoodInfo(foodId).run {
            return ProductFilter(
                title,
                calcium = nutrition.nutrients.find { it.name == "Calcium" }?.amount?.toString(),
                cholesterol = nutrition.nutrients.find { it.name == "Cholesterol" }?.amount?.toString(),
                fat = nutrition.nutrients.find { it.name == "Fat" }?.amount?.toString(),
                protein = nutrition.nutrients.find { it.name == "Protein" }?.amount?.toString(),
                carbohydrates = nutrition.nutrients.find { it.name == "Carbohydrates" }?.amount?.toString(),
                calories = nutrition.nutrients.find { it.name == "Calories" }?.amount?.toString(),
                sugar = nutrition.nutrients.find { it.name == "Sugar" }?.amount?.toString(),
                importantBadges,
                ingredientList
            )
        }
    }
}
