package com.example.feastlyandroid.retrofit

import com.google.gson.annotations.SerializedName

data class ResultData<T>(
   @SerializedName("success") val success: Boolean,
   @SerializedName("message") val message: String,
   @SerializedName("data") val data: List<T>
)