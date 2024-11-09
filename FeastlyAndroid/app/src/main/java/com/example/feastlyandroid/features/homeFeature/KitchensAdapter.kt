package com.example.feastlyandroid.features.homeFeature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.KitchenDesignBinding
import com.example.feastlyandroid.utils.PicassoImage

class KitchensAdapter(var mContext:Context,
                      var kitchenList:List<Kitchen>,
                      var viewModel: HomeViewModel) : RecyclerView.Adapter<KitchensAdapter.KitchesDesigneerKeeper>() {
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
        return kitchenList.size
    }

    override fun onBindViewHolder(holder: KitchesDesigneerKeeper, position: Int) {
        val kitchen = kitchenList[position]
        holder.desing.kitchenNameTxt.text = kitchen.name
        PicassoImage.covertToPicasso(kitchen.imageURL,holder.desing.kitchenImage)
    }
}