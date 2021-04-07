package com.rezyfr.dicoding.core.data.source.local

import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getFavoriteTourism(): Flow<List<MovieEntity>> = movieDao.getAllFavoriteMovies()

    fun insertFavoriteMovie(movie: MovieEntity) {
        movieDao.insert(movie)
    }

    fun deleteFavoriteMovie(id: Int?) {
        movieDao.deleteFavoriteMoviesById(id)
    }

    fun checkIfMovieFavorited(id: Int?) = movieDao.exists(id)

}