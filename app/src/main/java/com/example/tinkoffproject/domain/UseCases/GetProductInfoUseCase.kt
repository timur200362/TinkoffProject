package com.example.tinkoffproject.domain.UseCases

import com.example.tinkoffproject.data.repository.LoadFoodRepository
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
