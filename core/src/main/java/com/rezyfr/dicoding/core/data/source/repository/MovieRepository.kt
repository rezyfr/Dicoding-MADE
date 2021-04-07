package com.rezyfr.dicoding.core.data.source.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rezyfr.dicoding.core.data.source.local.LocalDataSource
import com.rezyfr.dicoding.core.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.repository.IMovieRepository
import com.rezyfr.dicoding.core.utils.MappingHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IMovieRepository {
    override fun discoverMovies(): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(pageSize = 10),
            pagingSourceFactory = { remoteDataSource }
        ).flow
    }

    override fun searchMovies(query: String): Flow<PagingData<Movie>> {
        remoteDataSource.query = query
        return Pager(
            PagingConfig(pageSize = 10),
            pagingSourceFactory = { remoteDataSource }
        ).flow
    }

    override suspend fun setFavoriteMovie(movie: Movie) {
        val movieEntity = MappingHelper.mapDomainToEntity(movie)
        localDataSource.insertFavoriteMovie(movieEntity)
    }

    override suspend fun getFavoriteMovies(): Flow<List<Movie>> = localDataSource.getFavoriteTourism().map {
        MappingHelper.mapEntitiesToDomain(it)
    }

    override suspend fun deleteMovieFromFavorite(id: Int?) {
        localDataSource.deleteFavoriteMovie(id)
    }

    override suspend fun checkIfMovieFavorited(id: Int?): Boolean = localDataSource.checkIfMovieFavorited(id)
}