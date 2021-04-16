package com.rezyfr.dicoding.core.data.source.remote.network

import com.rezyfr.dicoding.core.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.core.data.source.remote.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {
    @GET("movie/")
    suspend fun discoverMovie(
        @Query("page") page: Int
    ): MovieListResponse

    @GET("movie/{type}")
    suspend fun getMovieByType(
        @Path("type") list: String,
        @Query("page") page: Int
    ): MovieListResponse

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String
    ): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int
    ): MovieDetailResponse
}