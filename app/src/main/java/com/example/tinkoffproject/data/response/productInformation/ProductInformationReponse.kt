package com.example.tinkoffproject.data.response.productInformation


import com.google.gson.annotations.SerializedName

data class ProductInformationReponse(
    @SerializedName("aisle")
    val aisle: String?,
    @SerializedName("badges")
    val badges: List<String?>?,
    @SerializedName("breadcrumbs")
    val breadcrumbs: List<String?>?,
    @SerializedName("generatedText")
    val generatedText: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imageType")
    val imageType: String?,
    @SerializedName("importantBadges")
    val importantBadges: List<String?>?,
    @SerializedName("ingredientCount")
    val ingredientCount: Int?,
    @SerializedName("ingredientList")
    val ingredientList: String?,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient?>?,
    @SerializedName("likes")
    val likes: Int?,
    @SerializedName("nutrition")
    val nutrition: Nutrition?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("servings")
    val servings: Servings?,
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double?,
    @SerializedName("title")
    val title: String?
)