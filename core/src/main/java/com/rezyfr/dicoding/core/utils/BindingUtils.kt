package com.rezyfr.dicoding.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter(("imageUrl"))
fun loadImageUrl(view: ImageView, url: String?) {
    url?.let { view.loadEclipseImage(url) }
}