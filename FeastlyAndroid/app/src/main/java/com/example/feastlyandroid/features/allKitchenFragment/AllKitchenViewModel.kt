package com.example.feastlyandroid.features.allKitchenFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feastlyandroid.features.homeFeature.Kitchen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllKitchenViewModel @Inject constructor(private val allKitchenRepository: AllKitchenRepositoryInterface)
    : ViewModel(){
    var kitchenList = MutableLiveData<List<Kitchen>>()
    init {
        getData()
    }
        private fun getData(){
            allKitchenRepository.getKitchens()
            kitchenList = allKitchenRepository.kitchens
        }
}