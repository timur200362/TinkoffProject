package com.example.tinkoffproject.presentation

import com.example.tinkoffproject.presentation.response.FoodApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL=""
const val API_KEY="19dd87ea73ea4d618f7661859d85dda1"

object Container {
    private val httpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit by lazy{
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val foodApi= retrofit.create(FoodApi::class.java)
}