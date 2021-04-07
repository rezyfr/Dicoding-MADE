package com.rezyfr.dicoding.core.domain.repository

import androidx.paging.PagingData
import com.rezyfr.dicoding.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun discoverMovies(): Flow<PagingData<Movie>>
    fun searchMovies(query: String): Flow<PagingData<Movie>>
    suspend fun setFavoriteMovie(movie: Movie)
    suspend fun getFavoriteMovies(): Flow<List<Movie>>
    suspend fun deleteMovieFromFavorite(id: Int?)
    suspend fun checkIfMovieFavorited(id: Int?): Boolean
}