package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class Nutrition(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: CaloricBreakdown?,
    @SerializedName("nutrients")
    val nutrients: List<Nutrient?>?
)