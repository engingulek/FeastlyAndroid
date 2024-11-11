package com.example.feastlyandroid.features.homeFeature.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyandroid.databinding.RestaurantListTypeOneBinding
import com.example.feastlyandroid.R
import com.example.feastlyandroid.features.homeFeature.HomeViewModel
import com.example.feastlyandroid.features.homeFeature.HomeViewModelInterface
import com.example.feastlyandroid.features.homeFeature.Restaurant
import com.example.feastlyandroid.utils.PicassoImage

class RestaurantListTypeOneAdapter(var mContext: Context,
                                   var list:List<Restaurant>,
                                   var viewModel: HomeViewModelInterface
) :
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
        return  list.count()
    }

    override fun onBindViewHolder(holder: RestaurnatDesignKeeper, position: Int) {
        val restaurant = list[position]
        holder.design.restaurantName.text = restaurant.name
        PicassoImage.covertToPicasso(restaurant.imageURL,holder.design.restaurantImageView)
       val kitchenType = restaurant.kitchens.joinToString(separator = ",") { it.name }
        holder.design.kitchensInfo.text = kitchenType
        val item = viewModel.calculateDistanceAndMinute(restaurant.latitude,restaurant.longitude)
        holder.design.kitchensInfo.text = kitchenType
        holder.design.restaurantInfo.text = "${String.format("%.2f", item.first)} km * ${String.format("%.2f", item.second)} dk * ${restaurant.minWage} min wage"
    }
}