package com.rezyfr.dicoding.made.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rezyfr.dicoding.core.data.source.local.LocalDataSource
import com.rezyfr.dicoding.core.data.source.remote.NowPlayingDataSource
import com.rezyfr.dicoding.core.data.source.remote.PopularDataSource
import com.rezyfr.dicoding.core.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.repository.IMovieRepository
import com.rezyfr.dicoding.core.utils.MappingHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class FakeMovieRepository (
    private val popularDataSource: PopularDataSource,
    private val nowPlayingDataSource: NowPlayingDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IMovieRepository {

    override fun discoverNowPlayingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(pageSize = 1, maxSize = 3),
            pagingSourceFactory = { nowPlayingDataSource }
        ).flow
    }

    override fun discoverPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(pageSize = 1, maxSize = 3),
            pagingSourceFactory = { popularDataSource }
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

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map {
            MappingHelper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun deleteMovieFromFavorite(id: Int?) {
        localDataSource.deleteFavoriteMovie(id)
    }

    override suspend fun checkIfMovieFavorited(id: Int?): Boolean =
        localDataSource.checkIfMovieFavorited(id)

    override suspend fun getMovieDetail(id: Int): Flow<Movie> = flow {
        emit(MappingHelper.mapDetailResponseToDomain(remoteDataSource.fetchMovieDetail(id)))
    }.flowOn(Dispatchers.IO)
}