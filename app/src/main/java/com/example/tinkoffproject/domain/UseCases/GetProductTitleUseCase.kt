package com.example.tinkoffproject.domain.UseCases

import com.example.tinkoffproject.data.repository.LoadFoodInfoRepository
import com.example.tinkoffproject.data.response.product.Product
import com.example.tinkoffproject.data.response.productInformation.ProductInformationResponse
import javax.inject.Inject

class GetProductTitleUseCase @Inject constructor(
    private val loadFoodInfoRepository: LoadFoodInfoRepository
) {
    suspend fun execute(foodId: Int): ProductResponse {
        loadFoodInfoRepository.getFoodInfo(foodId).run {
            return ProductResponse(
                title
            )
        }
    }
}
data class ProductResponse(
    val title:String
)
//title
//nutrition(Calcium,Cholesterol,Fat,Protein,Carbohydrates,Calories,Sugar)
//importantBadges
//ingredientList