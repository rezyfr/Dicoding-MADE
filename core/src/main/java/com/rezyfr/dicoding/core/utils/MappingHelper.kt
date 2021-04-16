package com.rezyfr.dicoding.core.utils

import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.core.data.source.remote.response.MovieResponse
import com.rezyfr.dicoding.core.domain.model.Movie

object MappingHelper {
    fun mapMovieResponseToDomain(input: List<MovieResponse>): List<Movie> {
        val movieList = ArrayList<Movie>()
        input.map {
            val movie = Movie(
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                title = it.title,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                id = it.id,
                voteCount = it.voteCount?.formatToK()
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapDomainToEntity(input: Movie): MovieEntity {
        return MovieEntity(
            id = input.id,
            title = input.title,
            backdropPath = input.backdropPath,
            originalLanguage = input.originalLanguage,
            voteAverage = input.voteAverage?.div(2),
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            overview = input.overview
        )
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> {
        return input.map {
            Movie(
                id = it.id,
                title = it.title,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                overview = it.overview,
                duration = it.runtime
            )
        }
    }

    fun mapDetailResponseToDomain(input: MovieDetailResponse): Movie {
        return Movie(
            id = input.id,
            title = input.title,
            backdropPath = input.backdropPath,
            originalLanguage = input.originalLanguage,
            voteAverage = input.voteAverage,
            voteCount = input.voteCount?.formatToK(),
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            overview = input.overview,
            duration = input.runtime?.formatToHourMinutes()
        )
    }
}