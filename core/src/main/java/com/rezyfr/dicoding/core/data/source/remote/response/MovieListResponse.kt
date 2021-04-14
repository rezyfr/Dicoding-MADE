package com.rezyfr.dicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieResponse>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)
