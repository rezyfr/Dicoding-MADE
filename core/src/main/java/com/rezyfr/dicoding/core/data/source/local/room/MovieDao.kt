package com.rezyfr.dicoding.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import com.rezyfr.dicoding.core.base.BaseDao
import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao : BaseDao<MovieEntity> {

    @Query("SELECT * FROM movie")
    fun getAllFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovie(id: Int?): Flow<MovieEntity>

    @Query("DELETE FROM movie WHERE id = :id")
    fun deleteFavoriteMoviesById(id: Int?)

    @Query("SELECT EXISTS (SELECT 1 FROM movie WHERE id = :id AND isFavorite = 1)")
    fun isFavorite(id: Int?): Boolean
}