package com.bootcamp.odev3.models.listing


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("first_page")
    val firstPage: Int,
    @SerializedName("first_page_url")
    val firstPageUrl: String,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("last_page_url")
    val lastPageUrl: String,
    @SerializedName("next_page_url")
    val nextPageUrl: String,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("previous_page_url")
    val previousPageUrl: Any,
    @SerializedName("total")
    val total: Int
)