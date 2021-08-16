package com.rezyfr.dicoding.made.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.rezyfr.dicoding.made.ui.components.MovieListItem

@ExperimentalAnimationApi
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val popularMovies = homeViewModel.popularMovies.collectAsLazyPagingItems()
    val topRatedMovies = homeViewModel.topRatedMovies.collectAsLazyPagingItems()
    Column() {
        CategoriesHeader("Now Playing")
        MovieListItem(list = popularMovies)
        CategoriesHeader("Top Rated")
        MovieListItem(list = topRatedMovies)
    }
}

@Composable
fun CategoriesHeader(text: String){
    Text(
        text = text,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(start = 16.dp)
    )
}
