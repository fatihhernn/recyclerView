package com.bootcamp.odev3.models.core


import com.bootcamp.odev3.models.listing.RestaurantAddress
import com.bootcamp.odev3.models.listing.RestaurantFood
import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logoUrl")
    val logoUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("restaurantAddress")
    val restaurantAddress: List<RestaurantAddress>,
    @SerializedName("restaurantFoods")
    val restaurantFoods: List<RestaurantFood>,
    @SerializedName("typeOfRestaurant")
    val typeOfRestaurant: String,
    @SerializedName("updated_at")
    val updatedAt: String
)