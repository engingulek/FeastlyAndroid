package com.example.feastlyandroid.features.homeFeature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.KitchenDesignBinding

class KitchensAdapter(var mContext:Context) : RecyclerView.Adapter<KitchensAdapter.KitchesDesigneerKeeper>() {
    inner class KitchesDesigneerKeeper(desing:KitchenDesignBinding)
        :RecyclerView.ViewHolder(desing.root){
            var desing:KitchenDesignBinding
            init {
                this.desing = desing
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchesDesigneerKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val desing:KitchenDesignBinding = DataBindingUtil.inflate(layoutInflater,R.layout.kitchen_design,parent,false)
        return  KitchesDesigneerKeeper(desing)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: KitchesDesigneerKeeper, position: Int) {
        holder.desing.kitchenNameTxt.text = "Name"
    }
}