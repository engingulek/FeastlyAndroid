package com.example.feastlyandroid.features.homeFeature.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.RestaurantListTypeTwoBinding
import com.example.feastlyandroid.features.homeFeature.HomeViewModel
import com.example.feastlyandroid.features.homeFeature.HomeViewModelInterface
import com.example.feastlyandroid.features.homeFeature.Restaurant
import com.example.feastlyandroid.utils.PicassoImage

class RestaurantListTypeTwoAdapter(var mContext: Context,
                                   var list:List<Restaurant>,
                                   var viewModel: HomeViewModelInterface
)
    : RecyclerView.Adapter<RestaurantListTypeTwoAdapter.RestaurantDesignKeeper>() {
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
        return list.count()
    }

    override fun onBindViewHolder(holder: RestaurantDesignKeeper, position: Int) {
        val restaurant = list[position]
        holder.desing.restaurantNameTxt.text = restaurant.name
        PicassoImage.covertToPicasso(restaurant.imageURL,holder.desing.imageView)
        val kitchenType = restaurant.kitchens.joinToString(separator = ",") { it.name }

        val item = viewModel.calculateDistanceAndMinute(restaurant.latitude,restaurant.longitude)

        holder.desing.restaurnatInfo.text = "${kitchenType} * ${String.format("%.2f", item.first)} km " +
                "* ${String.format("%.2f", item.second)} dk " +
                "* ${restaurant.minWage} min wage"
    }


}