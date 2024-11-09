package com.example.feastlyandroid.features.homeFeature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

interface  KitchenRepositoryInterface {
    var kitchens:MutableLiveData<List<Kitchen>>
    fun  getKitchens()
}


class KitchenRepository (private var service: HomeServiceInterface) : KitchenRepositoryInterface {
   override var kitchens:MutableLiveData<List<Kitchen>> = MutableLiveData(emptyList())

    override fun getKitchens(){
        service.fetchAllKitchens()
        kitchens =  service.allKitchenList
    }


}