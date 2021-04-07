package com.rezyfr.dicoding.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter(("imageUrl"))
fun loadImageUrl(view: ImageView, url: String?) {
    url?.let { view.loadImage(url) }
}

@BindingAdapter(("shapeableImageUrl"))
fun loadShapeableImageUrl(view: ShapeableImageView, url: String?) {
    url?.let { view.loadShapeableImage(url) }
}