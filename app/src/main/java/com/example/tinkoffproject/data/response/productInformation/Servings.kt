package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class Servings(
    @SerializedName("number")
    val number: Double,//
    @SerializedName("size")
    val size: Double,//
    @SerializedName("unit")
    val unit: String
)