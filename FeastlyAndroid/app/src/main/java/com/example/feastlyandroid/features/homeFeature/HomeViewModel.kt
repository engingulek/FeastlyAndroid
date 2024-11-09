package com.example.feastlyandroid.features.homeFeature

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val kitchenRepository: KitchenRepositoryInterface) : ViewModel(){
    var kitchenList = MutableLiveData<List<Kitchen>>()

    init {
        getData()
    }

    private  fun getData(){
        kitchenRepository.getKitchens()
        kitchenList = kitchenRepository.kitchens
    }


}