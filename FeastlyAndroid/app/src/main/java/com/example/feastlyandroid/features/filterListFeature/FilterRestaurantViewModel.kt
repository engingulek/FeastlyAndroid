package com.example.feastlyandroid.features.filterListFeature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feastlyandroid.features.homeFeature.Kitchen
import com.example.feastlyandroid.features.homeFeature.Restaurant
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

interface FilterRestaurantViewModelInterface{
    var filterRestaurantList : MutableLiveData<List<Restaurant>>
    fun getData(list:List<String>)
    fun calculateDistanceAndMinute(latitude:Double,longitude:Double) : Pair<Double,Double>

}

@HiltViewModel
class FilterRestaurantViewModel @Inject constructor(private val filterRestaurantRepository: FilterRestaurantRepositoryInterface)
    : ViewModel(),FilterRestaurantViewModelInterface {
  override  var filterRestaurantList = MutableLiveData<List<Restaurant>>()

   override fun getData(list:List<String>){
        val gson = Gson()
        val filterRequest = FilterRequest(list)
        val json = gson.toJson(filterRequest)
        filterRestaurantRepository.getRestaurants(json)
       filterRestaurantList = filterRestaurantRepository.filterRestaurants
    }

    override fun calculateDistanceAndMinute(latitude:Double,longitude:Double) : Pair<Double,Double> {
        val corelatitude = 41.09732
        val corlongitude = 29.03126

        val R = 6371.0


        val coreLat1Rad = Math.toRadians(corelatitude)
        val coreLon2Rad = Math.toRadians(corlongitude)
        val lat2Rad = Math.toRadians(latitude)

        val lon2Rad = Math.toRadians(longitude)


        val dLat = lat2Rad - coreLat1Rad
        val dLon = lon2Rad - coreLon2Rad


        val a = sin(dLat / 2).pow(2) + cos(coreLat1Rad) * cos(lat2Rad) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        val km = R*c
        val minute = km / 25
        return Pair(km,minute)
    }
}