package com.rezyfr.dicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class MovieResponse(

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("original_language")
    val originalLanguage: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null
)

