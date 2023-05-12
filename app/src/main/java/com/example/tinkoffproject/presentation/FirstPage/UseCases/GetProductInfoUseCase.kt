package com.example.tinkoffproject.presentation.FirstPage.UseCases

import com.example.tinkoffproject.data.Repository.LoadFoodRepository
import com.example.tinkoffproject.data.response.product.Product
import javax.inject.Inject


class GetProductInfoUseCase @Inject constructor(
    private val loadFoodRepository: LoadFoodRepository
) {
    suspend fun execute(foodName:String): List<Product> {
        loadFoodRepository.getFoodName(foodName).run {
            return products
        }
    }
}
