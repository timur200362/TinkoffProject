package com.example.tinkoffproject.data.repository

import com.example.tinkoffproject.data.FoodApi
import com.example.tinkoffproject.data.response.product.SearchProduct
import javax.inject.Inject


class LoadFoodRepository @Inject constructor(private val foodApi: FoodApi) {
    suspend fun getFoodName(foodName: String): SearchProduct {
        return foodApi.getFood(foodName)
    }
}