package com.rezyfr.dicoding.core.data.source.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rezyfr.dicoding.core.data.source.remote.MoviePagingDataSource
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val moviePagingDataSource: MoviePagingDataSource
) : IMovieRepository {
    override fun discoverMovies(): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(pageSize = 10),
            pagingSourceFactory = { moviePagingDataSource }
        ).flow
    }
}