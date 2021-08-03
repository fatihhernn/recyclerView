package com.bootcamp.odev3.models.listing


import com.bootcamp.odev3.models.core.Restaurant
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val `data`: List<Restaurant>,
    @SerializedName("meta")
    val meta: Meta
)