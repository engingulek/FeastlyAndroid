package com.example.feastlyandroid.utils

import android.widget.ImageView
import com.example.feastlyandroid.R
import com.squareup.picasso.Picasso

class PicassoImage {
    companion object {
        fun covertToPicasso(url:String,image: ImageView) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error)
                .into(image)
        }
    }
}