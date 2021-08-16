package com.rezyfr.dicoding.made

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class MovieScreen(
    val icon: ImageVector? = null
) {
    Splash,
    Home(
        icon = Icons.Filled.Home
    ),
    Search(
        icon = Icons.Filled.Search
    ),
    Favorite(
        icon = Icons.Filled.Favorite
    );

    companion object {
        fun fromRoute(route: String?): MovieScreen =
            when (route?.substringBefore("/")) {
                Splash.name -> Splash
                Home.name -> Home
                Search.name -> Search
                Favorite.name -> Favorite
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}