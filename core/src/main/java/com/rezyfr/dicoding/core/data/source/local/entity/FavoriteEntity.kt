package com.rezyfr.dicoding.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rezyfr.dicoding.core.BuildConfig

@Entity(tableName = "movie")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val title: String? = null,
    val original_language: String? = null,
    val runtime: Int? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val budget: Int? = null,
) {
    fun getFullPosterPath() =
        if (poster_path.isNullOrBlank()) null else BuildConfig.IMAGE_URL + poster_path
}
