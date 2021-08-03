package com.bootcamp.odev3.utils

import com.bootcamp.odev3.models.core.Restaurant
import com.bootcamp.odev3.models.listing.RestaurantsBaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantApiService {
    @GET("restaurants")
    fun listCharacters(@Query("page") page: Int): Call<RestaurantsBaseResponse>

    @GET("restaurants/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Restaurant>
}