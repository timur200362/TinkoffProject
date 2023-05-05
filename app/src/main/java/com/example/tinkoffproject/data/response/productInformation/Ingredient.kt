package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("description")
    val description: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("safety_level")
    val safetyLevel: String?
)