package com.rezyfr.dicoding.core.di

import com.rezyfr.dicoding.core.data.source.local.LocalDataSource
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
    fun provideMovieDataSource(tmdbService: TmdbService): RemoteDataSource =
        RemoteDataSource(tmdbService)

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): IMovieRepository =
        MovieRepository(remoteDataSource, localDataSource)

}