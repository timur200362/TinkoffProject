package com.example.tinkoffproject.domain.UseCases

import com.example.tinkoffproject.data.repository.LoadFoodInfoRepository
import com.example.tinkoffproject.data.response.productInformation.Nutrient
import javax.inject.Inject

class GetProductTitleUseCase @Inject constructor(
    private val loadFoodInfoRepository: LoadFoodInfoRepository
) {
    suspend fun execute(foodId: Int): ProductResponse {
        loadFoodInfoRepository.getFoodInfo(foodId).run {
            return ProductResponse(
                title,
                nutrition = NutritionResponse(nutrition.nutrients),
                importantBadges,
                ingredientList
            )
        }
    }
}
data class ProductResponse(
    val title:String,
    val nutrition: NutritionResponse,
    val importantBadges: List<String>,
    val ingredientList: String
)
data class NutritionResponse(
    val nutrients: List<Nutrient>
)