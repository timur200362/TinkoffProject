package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class ProductInformationResponse(
    @SerializedName("aisle")
    val aisle: String,
    @SerializedName("badges")
    val badges: List<String>,
    @SerializedName("breadcrumbs")
    val breadcrumbs: List<String>,
    @SerializedName("generatedText")
    val generatedText: Any,
    @SerializedName("id")
    val id: Double,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("importantBadges")
    val importantBadges: List<String>,
    @SerializedName("ingredientCount")
    val ingredientCount: Double,
    @SerializedName("ingredientList")
    val ingredientList: String,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>,
    @SerializedName("likes")
    val likes: Double,
    @SerializedName("nutrition")
    val nutrition: Nutrition,
    @SerializedName("price")
    val price: Double,
    @SerializedName("servings")
    val servings: Servings,
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String
)