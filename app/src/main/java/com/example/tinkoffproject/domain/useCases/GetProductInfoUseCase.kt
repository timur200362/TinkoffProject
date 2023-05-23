package com.example.tinkoffproject.domain.useCases

import com.example.tinkoffproject.data.repository.LoadFoodInfoRepository
import javax.inject.Inject

class GetProductTitleUseCase @Inject constructor(
    private val loadFoodInfoRepository: LoadFoodInfoRepository
) {
    suspend fun execute(foodId: Int): ProductFilter {
        loadFoodInfoRepository.getFoodInfo(foodId).run {
            return ProductFilter(
                title,
                calcium = nutrition.nutrients.find { it.name=="Calcium" }?.let {
                    it.amount.toString() + it.unit
                },
                cholesterol = nutrition.nutrients.find { it.name=="Cholesterol" }?.let {
                    it.amount.toString() + it.unit
                },
                fat = nutrition.nutrients.find { it.name=="Fat" }?.let {
                    it.amount.toString() + it.unit
                },
                protein = nutrition.nutrients.find { it.name=="Protein" }?.let {
                    it.amount.toString() + it.unit
                },
                carbohydrates = nutrition.nutrients.find { it.name=="Carbohydrates" }?.let {
                    it.amount.toString() + it.unit
                },
                calories = nutrition.nutrients.find { it.name=="Calories" }?.let {
                    it.amount.toString() + it.unit
                },
                sugar = nutrition.nutrients.find { it.name=="Sugar" }?.let {
                    it.amount.toString() + it.unit
                },
                importantBadges,
                ingredientList
            )
        }
    }
}
data class ProductFilter(
    val title:String,
    val calcium:String?,
    val cholesterol:String?,
    val fat:String?,
    val protein:String?,
    val carbohydrates:String?,
    val calories:String?,
    val sugar:String?,
    val importantBadges: List<String>,
    val ingredientList: String
)