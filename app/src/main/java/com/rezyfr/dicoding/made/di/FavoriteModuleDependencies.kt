package com.rezyfr.dicoding.made.di

import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun movieUseCase(): MovieUseCase
}