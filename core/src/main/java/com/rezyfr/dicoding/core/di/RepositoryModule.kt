package com.rezyfr.dicoding.core.di

import com.rezyfr.dicoding.core.data.source.remote.MoviePagingDataSource
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
    fun provideMovieDataSource(tmdbService: TmdbService): MoviePagingDataSource =
        MoviePagingDataSource(tmdbService)

    @Provides
    fun provideRepository(moviePagingDataSource: MoviePagingDataSource): IMovieRepository =
        MovieRepository(moviePagingDataSource)

}