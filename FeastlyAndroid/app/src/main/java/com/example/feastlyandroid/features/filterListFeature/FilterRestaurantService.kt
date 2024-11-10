package com.example.feastlyandroid.features.filterListFeature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.feastlyandroid.features.homeFeature.Restaurant
import com.example.feastlyandroid.retrofit.ApiService
import com.example.feastlyandroid.retrofit.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface FilterRestaurantServiceInterface {
    var filterRestaurantList: MutableLiveData<List<Restaurant>>
    fun fetchRestaurants(list:String)
}

class FilterRestaurantService(private val apiService: ApiService) : FilterRestaurantServiceInterface {
    override var filterRestaurantList:MutableLiveData<List<Restaurant>> =  MutableLiveData(emptyList())
    override fun fetchRestaurants(list:String) {
        apiService.filterRestaurantByKitchen(list).enqueue(object :
            Callback<ResultData<Restaurant>> {
            override fun onResponse(
                call: Call<ResultData<Restaurant>>,
                response: Response<ResultData<Restaurant>>
            ) {
                val list = response.body()?.data
                filterRestaurantList.value = list ?: emptyList()
                Log.e("service mm","${list?.count()}")
            }

            override fun onFailure(call: Call<ResultData<Restaurant>>, t: Throwable) {
                filterRestaurantList.value = emptyList()
                Log.e("List Error","${t.message}")
            }
        })
    }
}