package com.example.feastlyandroid.retrofit

import com.example.feastlyandroid.features.filterListFeature.FilterRequest
import retrofit2.Call
import com.example.feastlyandroid.features.homeFeature.Kitchen
import com.example.feastlyandroid.features.homeFeature.Restaurant
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("kitchen/getAll")
    fun getAllKitchen() :Call<ResultData<Kitchen>>

    @GET("restaurant/getAll")
    fun getAllRestaurant() : Call<ResultData<Restaurant>>

    @FormUrlEncoded
    @POST("restaurant/filterByKitchen")
    fun filterRestaurantByKitchen(@Field("selectedList") selectedList: String): Call<ResultData<Restaurant>>

}