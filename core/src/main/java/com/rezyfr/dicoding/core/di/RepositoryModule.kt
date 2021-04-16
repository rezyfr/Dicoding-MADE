package com.rezyfr.dicoding.core.di

import com.rezyfr.dicoding.core.data.source.local.LocalDataSource
import com.rezyfr.dicoding.core.data.source.remote.NowPlayingDataSource
import com.rezyfr.dicoding.core.data.source.remote.PopularDataSource
import com.rezyfr.dicoding.core.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.core.data.source.remote.network.TmdbService
import com.rezyfr.dicoding.core.data.source.repository.MovieRepository
import com.rezyfr.dicoding.core.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    fun provideRemoteDataSource(tmdbService: TmdbService): RemoteDataSource =
        RemoteDataSource(tmdbService)

    @Provides
    fun providePopularDataSource(tmdbService: TmdbService): PopularDataSource =
        PopularDataSource(tmdbService)

    @Provides
    fun provideNowPlayingSource(tmdbService: TmdbService): NowPlayingDataSource =
        NowPlayingDataSource(tmdbService)

    @Provides
    fun provideRepository(
        popularDataSource: PopularDataSource,
        nowPlayingDataSource: NowPlayingDataSource,
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): IMovieRepository =
        MovieRepository(popularDataSource, nowPlayingDataSource, remoteDataSource, localDataSource)

}