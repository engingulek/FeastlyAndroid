package com.example.feastlyandroid.features.allKitchenFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.feastlyandroid.features.homeFeature.Kitchen
import com.example.feastlyandroid.retrofit.ApiService
import com.example.feastlyandroid.retrofit.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


interface AllKitchenServiceInterface {
    var allKitchenList: MutableLiveData<List<Kitchen>>
    fun fetchAllKitchens()
}

class AllKitchenService(private val apiService: ApiService) :  AllKitchenServiceInterface {

    override var allKitchenList: MutableLiveData<List<Kitchen>> = MutableLiveData(emptyList())

    override  fun fetchAllKitchens()  {
        apiService.getAllKitchen().enqueue(object : Callback<ResultData<Kitchen>> {
            override fun onResponse(
                call: Call<ResultData<Kitchen>>,
                response: Response<ResultData<Kitchen>>
            ) {
                val list = response.body()?.data
                allKitchenList.value = list ?: emptyList()
            }

            override fun onFailure(call: Call<ResultData<Kitchen>>, t: Throwable) {
                allKitchenList.value = emptyList()
            }
        })

    }
}