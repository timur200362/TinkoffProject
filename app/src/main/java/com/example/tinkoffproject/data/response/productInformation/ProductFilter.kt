package com.example.tinkoffproject.data.response.productInformation

data class ProductFilter(
    val id: Double,
    val title: String,
    val calcium: String?,
    val cholesterol: String?,
    val fat: String?,
    val protein: String?,
    val carbohydrates: String?,
    val calories: String?,
    val sugar: String?,
    val importantBadges: List<String>,
    val ingredientList: String
)