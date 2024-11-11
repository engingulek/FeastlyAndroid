package com.example.feastlyandroid.features.homeFeature

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Restaurant (
    @SerializedName("id")  val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("kitchens")  val kitchens: List<Kitchen>,
    @SerializedName("imageUrl") val imageURL: String,
    @SerializedName("latitude")  val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("minWage") val minWage: Long
) : Serializable