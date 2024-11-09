package com.example.feastlyandroid.features.allKitchenFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.KitchenDesignBinding


import com.example.feastlyandroid.features.homeFeature.KitchensAdapter

class AllKitchenAdapter(var mContext: Context)
    : RecyclerView.Adapter<AllKitchenAdapter.AllKitchesDesigneerKeeper>() {
    inner class AllKitchesDesigneerKeeper(desing: KitchenDesignBinding)
        :RecyclerView.ViewHolder(desing.root){
        var desing: KitchenDesignBinding
        init {
            this.desing = desing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllKitchesDesigneerKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val desing:KitchenDesignBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.kitchen_design,parent,false)
        return  AllKitchesDesigneerKeeper(desing)
    }

    override fun getItemCount(): Int {
        return  10
    }

    override fun onBindViewHolder(holder: AllKitchesDesigneerKeeper, position: Int) {
        holder.desing.kitchenNameTxt.text = "Name"
    }

}