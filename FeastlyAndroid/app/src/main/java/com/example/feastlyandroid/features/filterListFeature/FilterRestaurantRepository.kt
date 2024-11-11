package com.example.feastlyandroid.features.filterListFeature

import androidx.lifecycle.MutableLiveData
import com.example.feastlyandroid.features.homeFeature.Restaurant

interface  FilterRestaurantRepositoryInterface {
    var filterRestaurants: MutableLiveData<List<Restaurant>>
    fun getRestaurants(list:String)
}
class FilterRestaurantRepository(private var service:FilterRestaurantServiceInterface) : FilterRestaurantRepositoryInterface {
    override  var filterRestaurants:MutableLiveData<List<Restaurant>> = MutableLiveData(emptyList())
    override fun getRestaurants(list:String) {
        service.fetchRestaurants(list)
        filterRestaurants = service.filterRestaurantList
    }
}