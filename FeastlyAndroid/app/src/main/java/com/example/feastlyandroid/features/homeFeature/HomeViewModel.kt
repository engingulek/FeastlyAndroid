package com.example.feastlyandroid.features.homeFeature

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.*

@HiltViewModel
class HomeViewModel @Inject constructor(private val kitchenRepository: KitchenRepositoryInterface) : ViewModel(){
    var kitchenList = MutableLiveData<List<Kitchen>>()
    var listDesignType = MutableLiveData<Boolean>()
    var restaurantList = MutableLiveData<List<Restaurant>>()
    private var listType:Boolean = false

    init {
        getData()
        listDesignType.value = listType
    }

    private  fun getData(){
        kitchenRepository.getKitchens()
        kitchenList = kitchenRepository.kitchens
        kitchenRepository.getRestaurants()
        restaurantList = kitchenRepository.restaurants
    }

    fun onClickListDesign()
    {
        listType = !listType
        listDesignType.value = listType
    }

    fun calculateDistanceAndMinute(latitude:Double,longitude:Double) : Pair<Double,Double> {
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