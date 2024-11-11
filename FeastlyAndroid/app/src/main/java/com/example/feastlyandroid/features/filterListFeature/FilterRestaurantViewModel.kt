package com.example.feastlyandroid.features.filterListFeature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feastlyandroid.features.homeFeature.Restaurant
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface FilterRestaurantViewModelInterface{
    var filterRestaurantList : MutableLiveData<List<Restaurant>>
    fun getData(list:List<String>)

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
}