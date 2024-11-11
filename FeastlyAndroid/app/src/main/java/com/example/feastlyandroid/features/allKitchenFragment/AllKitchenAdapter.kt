package com.example.feastlyandroid.features.allKitchenFragment

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.KitchenDesignBinding
import com.example.feastlyandroid.features.homeFeature.Kitchen

import com.example.feastlyandroid.utils.PicassoImage

class AllKitchenAdapter(var mContext: Context,
                        var viewModel: AllKitchenViewModelInterface,
                        var list:List<Kitchen>)
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
        return  list.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: AllKitchesDesigneerKeeper, position: Int) {
        val kitchen = list[position]
        holder.desing.kitchenNameTxt.text = kitchen.name
        PicassoImage.covertToPicasso(kitchen.imageURL,holder.desing.kitchenImage)

        holder.desing.kitchenConstraintLayout.setOnClickListener {
            viewModel.onClickKitchen(kitchen.id)
            notifyDataSetChanged()
        }

        val result = viewModel.kitchenDesignType(kitchen.id)
        holder.desing.designType = result
    }



}