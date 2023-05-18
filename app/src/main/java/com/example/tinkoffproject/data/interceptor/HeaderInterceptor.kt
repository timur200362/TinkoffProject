package com.example.tinkoffproject.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newUrl = original.url.newBuilder()
            .addPathSegment("id")
            .build()

        return chain.proceed(
            original.newBuilder()
                .url(newUrl)
                .addHeader("x-api-key", API_KEY)
                .build()
        )
    }
}