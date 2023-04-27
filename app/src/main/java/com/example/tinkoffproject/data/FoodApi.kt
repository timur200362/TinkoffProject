package com.example.tinkoffproject.data

import com.example.tinkoffproject.data.response.product.SearchProduct
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("food/products/search")
    suspend fun getFood(@Query("query") name:String):SearchProduct

}