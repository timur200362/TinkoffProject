package com.example.tinkoffproject.data

import com.example.tinkoffproject.presentation.FirstPage.Model.Food

class FoodRepository {
    suspend fun getFoodName(id:Int):List<Food>{
        val response=FoodContainer.foodInfoApi.getFoodListInfo(id)
        return response.list.map { Food(it.title!!) }
    }
}