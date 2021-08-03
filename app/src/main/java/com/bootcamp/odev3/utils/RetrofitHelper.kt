package com.bootcamp.odev3.utils

import android.util.Log
import com.bootcamp.odev3.models.listing.RestaurantsBaseResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface RetrofitResponseHandler {
    fun onResponse(response: RestaurantsBaseResponse)
    fun onError()
}


class RetrofitHelper {
    private val okhttp: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        ).build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://yemeksepeti-android-hw3-api.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp)
        .build()

    var service: RestaurantApiService = retrofit.create(RestaurantApiService::class.java)


    fun listCharacter(page: Int = 1, callBack: RetrofitResponseHandler) {
        service.listCharacters(page).enqueue(object : Callback<RestaurantsBaseResponse> {
            override fun onResponse(
                call: Call<RestaurantsBaseResponse>,
                response: Response<RestaurantsBaseResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callBack.onResponse(it)
                    }
                } else {
                    callBack.onError()
                    Log.v("RetrofitHelper", "any errors.")
                }
            }

            override fun onFailure(call: Call<RestaurantsBaseResponse>, t: Throwable) {
                Log.v("RetrofitHelper", "onFailure -> service unavailable errors.")
                callBack.onError()
            }
        })
    }
}