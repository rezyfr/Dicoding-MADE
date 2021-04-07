package com.rezyfr.dicoding.core.utils

import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.remote.response.MovieResponse
import com.rezyfr.dicoding.core.domain.model.Movie

object MappingHelper {
    fun mapMovieResponseToDomain(input: List<MovieResponse>): List<Movie> {
        val movieList = ArrayList<Movie>()
        input.map {
            val movie = Movie(
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                genreIds = it.genreIds,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                id = it.id,
                adult = it.adult,
                voteCount = it.voteCount
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
            voteAverage = input.voteAverage,
            posterPath = input.posterPath,
            releaseDate = input.releaseDate
        )
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> {
        val domainList = arrayListOf<Movie>()
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate
            )
        }

        return domainList
    }
}