package com.rezyfr.dicoding.core.domain.usecase

import androidx.paging.PagingData
import com.rezyfr.dicoding.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun discoverMovies(): Flow<PagingData<Movie>>
}