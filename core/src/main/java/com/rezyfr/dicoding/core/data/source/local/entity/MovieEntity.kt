package com.rezyfr.dicoding.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = 0,
    val title: String? = null,
    val originalLanguage: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = null,
    val overview: String? = null,
)
