package com.rezyfr.dicoding.core.data.source.local

import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.local.room.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getFavoriteTourism(): Flow<List<MovieEntity>> {
        CoroutineScope(Dispatchers.Default).launch {
            movieDao.getAllFavoriteMovies().collect {
                Timber.d("DataWithFlow: $it")
            }
        }
        return movieDao.getAllFavoriteMovies()
    }


    fun insertFavoriteMovie(movie: MovieEntity) {
        movieDao.insert(movie)
    }

    fun deleteFavoriteMovie(id: Int?) {
        movieDao.deleteFavoriteMoviesById(id)
    }

    fun checkIfMovieFavorited(id: Int?) = movieDao.exists(id)

}