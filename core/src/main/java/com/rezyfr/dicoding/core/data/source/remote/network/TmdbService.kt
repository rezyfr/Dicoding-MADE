package com.rezyfr.dicoding.core.data.source.remote.network

import com.rezyfr.dicoding.core.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.core.data.source.remote.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {
    @GET("3/discover/movie")
    suspend fun getDiscoverMovie(
        @Query("page") page: Int
    ): MovieListResponse

    @GET("3/search/movie")
    suspend fun searchMovie(
        @Query("query") query: String
    ): MovieListResponse

    @GET("3/movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movie_id: Int
    ): MovieDetailResponse
}