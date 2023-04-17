package com.example.tinkoffproject.presentation.response


import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("query")
    val query: String?,
    @SerializedName("searchResults")
    val searchResults: List<SearchResult?>?,
    @SerializedName("totalResults")
    val totalResults: Int?
)
data class Product(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imageType")
    val imageType: String?,
    @SerializedName("title")
    val title: String?
)
data class SearchResult(
    @SerializedName("name")
    val name: String?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("totalResults")
    val totalResults: Int?
)
data class Result(
    @SerializedName("content")
    val content: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("relevance")
    val relevance: Int?,
    @SerializedName("type")
    val type: String?
)