package com.example.feastlyandroid.features.homeFeature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.feastlyandroid.retrofit.ApiService
import com.example.feastlyandroid.retrofit.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

interface HomeServiceInterface {
    var allKitchenList:MutableLiveData<List<Kitchen>>
    fun fetchAllKitchens()
}

class HomeService(private val apiService: ApiService) :  HomeServiceInterface {

    override var allKitchenList:MutableLiveData<List<Kitchen>> = MutableLiveData(emptyList())

  override  fun fetchAllKitchens()  {
        apiService.getAllKitchen().enqueue(object : Callback<ResultData<Kitchen>>{
            override fun onResponse(
                call: Call<ResultData<Kitchen>>,
                response: Response<ResultData<Kitchen>>
            ) {
                val list = response.body()?.data
                allKitchenList.value = list ?: emptyList()
                Log.e("service","${list?.count()}")
            }

            override fun onFailure(call: Call<ResultData<Kitchen>>, t: Throwable) {
               allKitchenList.value = emptyList()
            }
        })

    }
}


