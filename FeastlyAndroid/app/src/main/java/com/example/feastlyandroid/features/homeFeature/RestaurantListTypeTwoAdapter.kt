package com.example.feastlyandroid.features.homeFeature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.RestaurantListTypeOneBinding
import com.example.feastlyandroid.databinding.RestaurantListTypeTwoBinding
import com.example.feastlyandroid.utils.PicassoImage

class RestaurantListTypeTwoAdapter(var mContext: Context,
    var viewModel: HomeViewModel) : RecyclerView.Adapter<RestaurantListTypeTwoAdapter.RestaurantDesignKeeper>() {
        inner  class RestaurantDesignKeeper(desing:RestaurantListTypeTwoBinding) :
                RecyclerView.ViewHolder(desing.root){
                    var desing:RestaurantListTypeTwoBinding
                    init {
                        this.desing = desing
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:RestaurantListTypeTwoBinding = DataBindingUtil.inflate(layoutInflater,R.layout.restaurant_list_type_two,parent,false)
        return RestaurantDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RestaurantDesignKeeper, position: Int) {
        holder.desing.restaurantNameTxt.text = "Name"
        PicassoImage.covertToPicasso("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGR6yh7uysHIwyfR6yGTcxed2XQgXgz3CZVw&s",holder.desing.imageView)
    }


}