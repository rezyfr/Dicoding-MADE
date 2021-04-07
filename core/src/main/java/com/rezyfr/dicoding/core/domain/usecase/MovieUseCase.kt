package com.rezyfr.dicoding.core.domain.usecase

import androidx.paging.PagingData
import com.rezyfr.dicoding.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun discoverMovies(): Flow<PagingData<Movie>>
    fun searchMovies(query: String): Flow<PagingData<Movie>>
    suspend fun setFavoriteMovie(movie: Movie)
    suspend fun getFavoriteMovies(): Flow<List<Movie>>
    suspend fun deleteMovieFromFavorite(id: Int?)
    suspend fun checkIfMovieFavorited(id: Int?): Boolean
}