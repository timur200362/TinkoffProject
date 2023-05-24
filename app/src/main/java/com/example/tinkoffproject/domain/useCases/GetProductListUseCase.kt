package com.example.tinkoffproject.domain.useCases

import com.example.tinkoffproject.data.repository.FoodRepository
import com.example.tinkoffproject.data.response.product.Product
import javax.inject.Inject


class GetProductListUseCase @Inject constructor(
    private val foodRepository: FoodRepository
) {
    suspend fun execute(foodName: String): List<Product> {
        foodRepository.getFoodName(foodName).run {
            return products
        }
    }
}
