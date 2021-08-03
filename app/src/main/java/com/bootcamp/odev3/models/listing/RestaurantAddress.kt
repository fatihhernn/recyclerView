package com.bootcamp.odev3.models.listing


import com.google.gson.annotations.SerializedName

data class RestaurantAddress(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("neighborhood")
    val neighborhood: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("updated_at")
    val updatedAt: String
)