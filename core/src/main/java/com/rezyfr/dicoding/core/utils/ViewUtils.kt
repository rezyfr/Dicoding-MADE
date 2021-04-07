package com.rezyfr.dicoding.core.utils

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

fun ImageView.loadImage(url: String?) {
    val loader = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        start()
    }

    val option = RequestOptions()
//        .error(R.drawable.ic_person)
        .placeholder(loader)
        .diskCacheStrategy(DiskCacheStrategy.ALL)


    try {
        Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun ShapeableImageView.loadShapeableImage(url: String?) {
    val loader = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        start()
    }

    val radius = 16F
    this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder()
        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
        .setTopLeftCorner(CornerFamily.ROUNDED, radius)
        .build()

    val option = RequestOptions()
//        .error(R.drawable.ic_person)
        .placeholder(loader)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
//        .circleCrop()

    try {
        Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}