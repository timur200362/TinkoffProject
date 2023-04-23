package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class Servings(
    @SerializedName("number")
    val number: Int?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("unit")
    val unit: String?
)