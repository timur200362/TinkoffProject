package com.example.tinkoffproject.presentation.response

import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("search")
    suspend fun getFood(@Query("query") name:String)
}