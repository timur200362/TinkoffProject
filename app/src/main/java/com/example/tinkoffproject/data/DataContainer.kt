package com.example.tinkoffproject.data

import com.example.tinkoffproject.BuildConfig
import com.example.tinkoffproject.data.FoodApi
import com.example.tinkoffproject.data.interceptor.ApiKeyInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL="https://api.spoonacular.com/food/products/search/"
const val API_KEY="19dd87ea73ea4d618f7661859d85dda1"

object Container {
    private val loggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val foodApi by lazy {
        retrofit.create(FoodApi::class.java)
    }
}