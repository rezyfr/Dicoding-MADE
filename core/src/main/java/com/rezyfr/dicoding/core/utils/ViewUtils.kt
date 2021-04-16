package com.rezyfr.dicoding.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.rezyfr.dicoding.core.R
import kotlin.math.ln
import kotlin.math.pow

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
        .setTopRightCorner(CornerFamily.ROUNDED, radius)
        .setBottomRightCorner(CornerFamily.ROUNDED, radius)
        .build()

    try {
        Glide.with(context)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Int.formatToK(): String {
    // source: https://stackoverflow.com/questions/9769554/how-to-convert-number-into-k-thousands-m-million-and-b-billion-suffix-in-jsp?lq=1
    if (this < 1000) return toString()
    val exp = ln(this.toDouble()).div(ln(1000.0)).toInt()
    return String.format("%.2f %c", this.div(1000.0.pow(exp)), "kMGTPE"[exp - 1])
}

fun Int.formatToHourMinutes(): String {
    val hours = this.div(60)
    val minutes = this % 60
    return String.format("%d: %02d: 00", hours, minutes)
}