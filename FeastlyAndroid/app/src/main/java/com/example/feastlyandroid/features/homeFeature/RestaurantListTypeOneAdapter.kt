package com.example.feastlyandroid.features.homeFeature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.databinding.RestaurantListTypeOneBinding
import com.example.feastlyandroid.R
import com.example.feastlyandroid.utils.PicassoImage

class RestaurantListTypeOneAdapter(var mContext: Context,
                        var viewModel: HomeViewModel) :
    RecyclerView.Adapter<RestaurantListTypeOneAdapter.RestaurnatDesignKeeper>() {

        inner class RestaurnatDesignKeeper(design:RestaurantListTypeOneBinding
                                           ) :

         RecyclerView.ViewHolder(design.root){
             var design:RestaurantListTypeOneBinding
             init {
                 this.design = design
             }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurnatDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:RestaurantListTypeOneBinding = DataBindingUtil.inflate(layoutInflater,R.layout.restaurant_list_type_one,parent,false)
        return RestaurnatDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return  10
    }

    override fun onBindViewHolder(holder: RestaurnatDesignKeeper, position: Int) {
        holder.design.restaurantName.text = "Name"
        PicassoImage.covertToPicasso("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGR6yh7uysHIwyfR6yGTcxed2XQgXgz3CZVw&s",holder.design.restaurantImageView)
    }
}