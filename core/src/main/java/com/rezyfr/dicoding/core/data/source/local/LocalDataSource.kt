package com.rezyfr.dicoding.core.data.source.local

import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getFavoriteMovies(): Flow<List<MovieEntity>> {
        return movieDao.getAllFavoriteMovies()
    }

    fun insertFavoriteMovie(movie: MovieEntity) {
        movie.favorite = 1
        movieDao.insert(movie)
    }

    fun deleteFavoriteMovie(id: Int?) {
        movieDao.deleteFavoriteMoviesById(id)
    }

    fun checkIfMovieFavorited(id: Int?) = movieDao.isFavorite(id)

}