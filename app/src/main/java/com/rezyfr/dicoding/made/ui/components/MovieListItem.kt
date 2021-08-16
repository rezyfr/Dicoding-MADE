package com.rezyfr.dicoding.made.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.rezyfr.dicoding.core.domain.model.Movie


@ExperimentalAnimationApi
@Composable
fun MovieListItem(list: LazyPagingItems<Movie>) {
    LazyRow(modifier = Modifier.padding(bottom = 32.dp)) {
        items(list) { movie ->
            movie?.let {
                Column(
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp)
                        .width(139.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    MovieListImage(imgPath = movie.getPosterImage().orEmpty())
                    this.MovieListDetail(movie = movie)
                }
            }
        }
    }
}

@Composable
fun MovieListImage(imgPath: String) {
    Image(
        modifier = Modifier
            .height(210.dp)
            .width(139.dp)
            .clip(RoundedCornerShape(8.dp)),
        painter = rememberImagePainter(
            data = imgPath,
            builder = {
                crossfade(true)
            },
        ), contentDescription = "Poster"
    )
}

@Composable
fun ColumnScope.MovieListDetail(movie: Movie) {
    val lineHeight = MaterialTheme.typography.body2.fontSize
    val voteAverage = movie.voteAverage?.toFloat() ?: 0.0F
    Text(
        text = movie.title.orEmpty(),
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .align(Alignment.Start)
            .padding(PaddingValues(top = 8.dp))
            .sizeIn(minHeight = with(LocalDensity.current) {
                (lineHeight * 3).toDp()
            }),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
    RatingBar(
        value = voteAverage / 2,
        ratingBarStyle = RatingBarStyle.HighLighted,
        size = 12.dp,
        modifier = Modifier
            .focusable(false)
            .padding(vertical = 4.dp)
    ) {
        //do nothing
    }
    Text(
        text = "${movie.voteCount.orEmpty()} Reviews",
        style = MaterialTheme.typography.body2,
    )
}