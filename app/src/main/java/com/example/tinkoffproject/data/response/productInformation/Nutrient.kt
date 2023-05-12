package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("percentOfDailyNeeds")
    val percentOfDailyNeeds: Double,
    @SerializedName("unit")
    val unit: String
)