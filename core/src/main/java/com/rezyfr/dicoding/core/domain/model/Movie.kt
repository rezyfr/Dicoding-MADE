package com.rezyfr.dicoding.core.domain.model

import android.os.Parcelable
import com.rezyfr.dicoding.core.BuildConfig
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val overview: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val genreIds: List<Int?>? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val popularity: Double? = null,
    val voteAverage: Double? = null,
    val id: Int? = null,
    val adult: Boolean? = null,
    val voteCount: String? = null,
    val duration: String? = null
) : Parcelable {

    fun getPosterImage() =
        if (posterPath.isNullOrBlank()) null else BuildConfig.IMAGE_URL + posterPath

    fun getBackdropImage() =
        if (backdropPath.isNullOrBlank()) null else BuildConfig.BACKDROP_URL + backdropPath
}
