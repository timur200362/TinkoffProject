package com.example.tinkoffproject.data

import com.example.tinkoffproject.data.response.product.SearchProduct
import com.example.tinkoffproject.data.response.productInformation.ProductInformationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {

    @GET("food/products/search")
    suspend fun getFood(@Query("query") name:String):SearchProduct

    @GET("food/products/{Id}")
    suspend fun getFoodInfo(@Path("Id") id:Int): ProductInformationResponse
}