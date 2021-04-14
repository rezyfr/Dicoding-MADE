package com.rezyfr.dicoding.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie")
    fun getAllFavoriteMoviesWithoutFlow(): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovie(id: Int?): Flow<MovieEntity>

    @Query("DELETE FROM movie WHERE id = :id")
    fun deleteFavoriteMoviesById(id: Int?)

    @Query("SELECT EXISTS (SELECT 1 FROM movie WHERE id = :id)")
    fun exists(id: Int?): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity): Long
}