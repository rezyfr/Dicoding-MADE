package com.rezyfr.dicoding.core.domain.usecase

import androidx.paging.PagingData
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository) :
    MovieUseCase {
    override fun discoverMovies(): Flow<PagingData<Movie>> {
        return movieRepository.discoverMovies()
    }

    override fun searchMovies(query: String): Flow<PagingData<Movie>> {
        return movieRepository.searchMovies(query)
    }

    override suspend fun setFavoriteMovie(movie: Movie) {
        movieRepository.setFavoriteMovie(movie)
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }

    override suspend fun deleteMovieFromFavorite(id: Int?) {
        movieRepository.deleteMovieFromFavorite(id)
    }

    override suspend fun checkIfMovieFavorited(id: Int?): Boolean =
        movieRepository.checkIfMovieFavorited(id)
}