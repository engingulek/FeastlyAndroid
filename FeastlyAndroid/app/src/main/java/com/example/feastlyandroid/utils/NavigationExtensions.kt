package com.example.feastlyandroid.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.NavDestination

import androidx.navigation.Navigation

fun  Navigation.toFragment(view:View,directionId:Int) {
    findNavController(view).navigate(directionId)
}

fun  Navigation.toFragment(view:View,directionId:NavDirections) {
    findNavController(view).navigate(directionId)
}