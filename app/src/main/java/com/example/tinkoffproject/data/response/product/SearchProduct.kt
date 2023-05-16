package com.example.tinkoffproject.data.response.product


import com.google.gson.annotations.SerializedName

data class SearchProduct(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("totalProducts")
    val totalProducts: Int,
    @SerializedName("type")
    val type: String
)