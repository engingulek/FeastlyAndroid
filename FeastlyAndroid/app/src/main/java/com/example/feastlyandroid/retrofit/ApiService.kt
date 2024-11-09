package com.example.feastlyandroid.retrofit

import retrofit2.Call
import com.example.feastlyandroid.features.homeFeature.Kitchen
import retrofit2.http.GET

interface ApiService {
    @GET("kitchen/getAll")
    fun getAllKitchen() :Call<ResultData<Kitchen>>
}