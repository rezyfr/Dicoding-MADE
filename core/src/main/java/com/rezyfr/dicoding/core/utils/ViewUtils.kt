package com.rezyfr.dicoding.core.utils

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

fun ImageView.loadEclipseImage(url: String?) {
    val loader = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        start()
    }

//    val option = RequestOptions()
//        .error(R.drawable.ic_person)
//        .placeholder(loader)
//        .diskCacheStrategy(DiskCacheStrategy.ALL)
//        .circleCrop()

    try {
        Glide.with(context)
//            .setDefaultRequestOptions(option)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}