package com.rezyfr.dicoding.made.ui.detail;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/rezyfr/dicoding/made/ui/detail/DetailViewModel;", "Lcom/rezyfr/dicoding/core/base/BaseViewModel;", "useCase", "Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;", "(Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;)V", "_isFavorited", "Landroidx/lifecycle/MutableLiveData;", "", "isFavorited", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "addMovieToFavorite", "", "movie", "Lcom/rezyfr/dicoding/core/domain/model/Movie;", "checkIfFavorited", "id", "", "(Ljava/lang/Integer;)V", "deleteFromFavorite", "app_debug"})
public final class DetailViewModel extends com.rezyfr.dicoding.core.base.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isFavorited = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorited = null;
    private final com.rezyfr.dicoding.core.domain.usecase.MovieUseCase useCase = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorited() {
        return null;
    }
    
    public final void addMovieToFavorite(@org.jetbrains.annotations.NotNull()
    com.rezyfr.dicoding.core.domain.model.Movie movie) {
    }
    
    public final void checkIfFavorited(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id) {
    }
    
    public final void deleteFromFavorite(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id) {
    }
    
    @javax.inject.Inject()
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    com.rezyfr.dicoding.core.domain.usecase.MovieUseCase useCase) {
        super();
    }
}