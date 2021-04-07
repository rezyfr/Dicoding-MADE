package com.rezyfr.dicoding.core.domain.repository

import androidx.paging.PagingData
import com.rezyfr.dicoding.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun discoverMovies(): Flow<PagingData<Movie>>
}