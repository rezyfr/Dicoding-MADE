package com.rezyfr.dicoding.core.utils

import com.rezyfr.dicoding.core.data.source.remote.response.MovieResponse
import com.rezyfr.dicoding.core.domain.model.Movie

object MappingHelper {
    fun mapResponseToDomain(input: List<MovieResponse>): List<Movie> {
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
}