package com.rezyfr.dicoding.made.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@dagger.hilt.EntryPoint()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/rezyfr/dicoding/made/di/FavoriteModuleDependencies;", "", "movieUseCase", "Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;", "app_debug"})
public abstract interface FavoriteModuleDependencies {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.rezyfr.dicoding.core.domain.usecase.MovieUseCase movieUseCase();
}