package com.example.tinkoffproject.data.response.productInformation

import com.google.gson.annotations.SerializedName

data class ProductListInformationResponse(
    @SerializedName("list")
    val list:List<ProductInformationResponse>
)