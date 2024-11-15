package com.example.feastlyandroid.features.homeFeature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

interface  HomeRepositoryInterface {
    var kitchens:MutableLiveData<List<Kitchen>>
    var restaurants:MutableLiveData<List<Restaurant>>
    fun  getKitchens()
    fun getRestaurants()
}


class HomeRepository (private var service: HomeServiceInterface) : HomeRepositoryInterface {
   override var kitchens:MutableLiveData<List<Kitchen>> = MutableLiveData(emptyList())
    override  var restaurants:MutableLiveData<List<Restaurant>> = MutableLiveData(emptyList())

    override fun getKitchens(){
        service.fetchAllKitchens()
        kitchens =  service.allKitchenList
    }

    override fun getRestaurants() {
        service.fetchRestaurants()
        restaurants = service.restaurantList
    }
}