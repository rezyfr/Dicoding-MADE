package com.rezyfr.dicoding.made.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/rezyfr/dicoding/made/di/AppModule;", "", "()V", "provideUseCase", "Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;", "repository", "Lcom/rezyfr/dicoding/core/data/source/repository/MovieRepository;", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.rezyfr.dicoding.made.di.AppModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.rezyfr.dicoding.core.domain.usecase.MovieUseCase provideUseCase(@org.jetbrains.annotations.NotNull()
    com.rezyfr.dicoding.core.data.source.repository.MovieRepository repository) {
        return null;
    }
    
    private AppModule() {
        super();
    }
}