package com.rezyfr.dicoding.made.ui.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/rezyfr/dicoding/made/ui/home/HomeViewModel;", "Lcom/rezyfr/dicoding/core/base/BaseViewModel;", "movieUseCase", "Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;", "(Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;)V", "_movieFlow", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/rezyfr/dicoding/core/domain/model/Movie;", "movieFlow", "getMovieFlow", "()Landroidx/lifecycle/LiveData;", "discoverMovies", "", "app_debug"})
public final class HomeViewModel extends com.rezyfr.dicoding.core.base.BaseViewModel {
    private androidx.lifecycle.LiveData<androidx.paging.PagingData<com.rezyfr.dicoding.core.domain.model.Movie>> _movieFlow;
    private final com.rezyfr.dicoding.core.domain.usecase.MovieUseCase movieUseCase = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.rezyfr.dicoding.core.domain.model.Movie>> getMovieFlow() {
        return null;
    }
    
    private final void discoverMovies() {
    }
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.rezyfr.dicoding.core.domain.usecase.MovieUseCase movieUseCase) {
        super();
    }
}