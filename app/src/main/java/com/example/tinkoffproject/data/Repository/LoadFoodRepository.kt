package com.example.tinkoffproject.data.Repository

import com.example.tinkoffproject.data.DataContainer
import com.example.tinkoffproject.data.FoodContainer
import com.example.tinkoffproject.data.response.product.SearchProduct
import javax.inject.Inject


class LoadFoodRepository @Inject constructor() {
    suspend fun getFoodName(foodName:String): SearchProduct {
        return DataContainer.foodApi.getFood(foodName)
    }
}