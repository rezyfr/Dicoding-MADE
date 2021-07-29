package com.rezyfr.dicoding.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int? = 0,
    var title: String? = null,
    var originalLanguage: String? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null,
    var releaseDate: String? = null,
    var voteAverage: Double? = null,
    var voteCount: String? = null,
    var runtime: String? = null,
    var overview: String? = null,
    var favorite: Int? = 0
)
