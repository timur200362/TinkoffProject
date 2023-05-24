package com.example.tinkoffproject.data.repository

import com.example.tinkoffproject.data.FoodApi
import com.example.tinkoffproject.data.response.product.SearchProduct
import com.example.tinkoffproject.data.response.productInformation.ProductInformationResponse
import javax.inject.Inject


class FoodRepository @Inject constructor(private val foodApi: FoodApi) {
    suspend fun getFoodName(foodName: String): SearchProduct {
        return foodApi.getFood(foodName)
    }
    suspend fun getFoodInfo(foodId: Int): ProductInformationResponse {
        return foodApi.getFoodInfo(foodId)
    }
}