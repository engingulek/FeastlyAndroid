package com.example.feastlyandroid.retrofit

import retrofit2.Retrofit
import retrofit2.create

class ApiUtils {
    companion object{

        val BASE_URL = "http://10.0.2.2:8080/api/feastly/"
        fun createService() : ApiService {
            return RetrofitClient.getClient(BASE_URL).create(ApiService::class.java)
        }
    }
}