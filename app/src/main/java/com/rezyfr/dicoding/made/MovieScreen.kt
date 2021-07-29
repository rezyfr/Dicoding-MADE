package com.rezyfr.dicoding.made

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

enum class MovieScreen() {
    Splash,
    Home;
    companion object {
        fun fromRoute(route: String?): MovieScreen =
            when (route?.substringBefore("/")) {
                Splash.name -> Splash
                Home.name -> Home
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}