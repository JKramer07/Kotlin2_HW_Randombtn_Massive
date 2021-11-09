package com.geek.kotlin2_hw_randombtn_massive.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(image: String) {
    Glide.with(context)
            .load(image)
            .centerCrop()
            .into(this)
}