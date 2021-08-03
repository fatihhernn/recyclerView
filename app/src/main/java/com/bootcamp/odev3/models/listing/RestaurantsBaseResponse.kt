package com.bootcamp.odev3.models.listing


import com.google.gson.annotations.SerializedName

data class RestaurantsBaseResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
)