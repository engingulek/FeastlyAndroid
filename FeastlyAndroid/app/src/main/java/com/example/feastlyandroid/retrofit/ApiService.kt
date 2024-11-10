package com.example.feastlyandroid.retrofit

import retrofit2.Call
import com.example.feastlyandroid.features.homeFeature.Kitchen
import com.example.feastlyandroid.features.homeFeature.Restaurant
import retrofit2.http.GET

interface ApiService {
    @GET("kitchen/getAll")
    fun getAllKitchen() :Call<ResultData<Kitchen>>

    @GET("restaurant/getAll")
    fun getAllRestaurant() : Call<ResultData<Restaurant>>
}