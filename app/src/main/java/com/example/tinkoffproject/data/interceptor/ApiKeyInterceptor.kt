package com.example.tinkoffproject.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

const val API_KEY="19dd87ea73ea4d618f7661859d85dda1"

class ApiKeyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original=chain.request()
        val newUrl=original.url.newBuilder()
            .addQueryParameter("apiKey", API_KEY)
            .build()

        return chain.proceed(
            original.newBuilder()
                .url(newUrl)
                .build()
        )
    }
}