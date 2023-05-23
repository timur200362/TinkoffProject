package com.example.tinkoffproject.data.repository

import com.example.tinkoffproject.data.FoodApi
import com.example.tinkoffproject.data.response.productInformation.ProductInformationResponse
import javax.inject.Inject

class LoadFoodInfoRepository @Inject constructor(private val foodApi: FoodApi) {
    suspend fun getFoodInfo(foodId:Int): ProductInformationResponse {
        return foodApi.getFoodInfo(foodId)
    }
}