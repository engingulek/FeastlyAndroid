package com.example.feastlyandroid.features.homeFeature

import com.google.gson.annotations.SerializedName

data class Kitchen (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageURL: String
)