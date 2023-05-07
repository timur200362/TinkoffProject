package com.example.tinkoffproject.presentation.FirstPage.UseCases

import com.example.tinkoffproject.data.Repository.LoadFoodRepository
import com.example.tinkoffproject.data.response.product.Product


class GetProductInfoUseCase {
    suspend fun execute(foodName:String): List<Product> {
        LoadFoodRepository().getFoodName(foodName).run {
            return products
        }
    }
}
