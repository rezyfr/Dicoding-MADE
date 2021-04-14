package com.rezyfr.dicoding.made.di

import com.rezyfr.dicoding.core.data.source.repository.MovieRepository
import com.rezyfr.dicoding.core.domain.usecase.MovieInteractor
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideUseCase(repository: MovieRepository): MovieUseCase =
        MovieInteractor(
            repository
        )
}