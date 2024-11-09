package com.example.feastlyandroid.features.allKitchenFragment

import androidx.lifecycle.MutableLiveData
import com.example.feastlyandroid.features.homeFeature.Kitchen


interface AllKitchenRepositoryInterface{
    var kitchens: MutableLiveData<List<Kitchen>>
    fun  getKitchens()
}

class AllKitchenRepository(private var service : AllKitchenServiceInterface)
    :AllKitchenRepositoryInterface{
    override var kitchens:MutableLiveData<List<Kitchen>> = MutableLiveData(emptyList())
    override fun getKitchens(){
        service.fetchAllKitchens()
        kitchens =  service.allKitchenList
    }
}