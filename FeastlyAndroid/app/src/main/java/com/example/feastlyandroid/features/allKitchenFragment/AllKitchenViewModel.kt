package com.example.feastlyandroid.features.allKitchenFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feastlyandroid.features.homeFeature.Kitchen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface  AllKitchenViewModelInterface {
    var kitchenList : MutableLiveData<List<Kitchen>>
    var selectedAllKitchenLiveData : MutableLiveData<List<String>>
    fun onClickKitchen(id:String)
    fun kitchenDesignType(id:String) : Boolean
    fun getSelectedList() : MutableList<String>

}

@HiltViewModel
class AllKitchenViewModel @Inject constructor(private val allKitchenRepository: AllKitchenRepositoryInterface)
    : ViewModel(),AllKitchenViewModelInterface{
  override  var kitchenList = MutableLiveData<List<Kitchen>>()
    override  var selectedAllKitchenLiveData = MutableLiveData<List<String>>()
    private val selectedAKitchenList = mutableListOf<String>()
    init {
        getData()
    }

    private fun getData(){
            allKitchenRepository.getKitchens()
            kitchenList = allKitchenRepository.kitchens
    }

    override fun onClickKitchen(id:String){
        val control = selectedAKitchenList.contains(id)

        if (control){
            selectedAKitchenList.remove(id)
        }else{
            selectedAKitchenList.add(id)
        }

        selectedAllKitchenLiveData.value = selectedAKitchenList
    }


    override fun kitchenDesignType(id:String) : Boolean {
        val control = selectedAKitchenList.contains(id)
        return  control
    }

    override fun getSelectedList() : MutableList<String> {
       return selectedAKitchenList
    }
}