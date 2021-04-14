package com.rezyfr.dicoding.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.rezyfr.dicoding.core.R

fun ImageView.loadImage(url: String?) {

    try {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.placeholder_movie)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun ShapeableImageView.loadShapeableImage(url: String?) {
    val radius = 16F
    this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder()
        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
        .setTopLeftCorner(CornerFamily.ROUNDED, radius)
        .build()

    try {
        Glide.with(context)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}