package com.bootcamp.odev3.models.listing


import com.google.gson.annotations.SerializedName

data class RestaurantFood(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("updated_at")
    val updatedAt: String
)