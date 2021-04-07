package com.rezyfr.dicoding.made.ui.search;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlinx.coroutines.ExperimentalCoroutinesApi()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/rezyfr/dicoding/made/ui/search/SearchViewModel;", "Lcom/rezyfr/dicoding/core/base/BaseViewModel;", "movieUseCase", "Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;", "(Lcom/rezyfr/dicoding/core/domain/usecase/MovieUseCase;)V", "_searchResult", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/rezyfr/dicoding/core/domain/model/Movie;", "queryChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "", "searchResult", "getSearchResult$annotations", "()V", "getSearchResult", "()Landroidx/lifecycle/LiveData;", "searchMovies", "", "query", "setSearchQuery", "search", "app_debug"})
public final class SearchViewModel extends com.rezyfr.dicoding.core.base.BaseViewModel {
    private androidx.lifecycle.LiveData<androidx.paging.PagingData<com.rezyfr.dicoding.core.domain.model.Movie>> _searchResult;
    private final kotlinx.coroutines.channels.ConflatedBroadcastChannel<java.lang.String> queryChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.rezyfr.dicoding.core.domain.model.Movie>> searchResult = null;
    private final com.rezyfr.dicoding.core.domain.usecase.MovieUseCase movieUseCase = null;
    
    private final void searchMovies(java.lang.String query) {
    }
    
    public final void setSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String search) {
    }
    
    @kotlinx.coroutines.FlowPreview()
    @java.lang.Deprecated()
    public static void getSearchResult$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.rezyfr.dicoding.core.domain.model.Movie>> getSearchResult() {
        return null;
    }
    
    @javax.inject.Inject()
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.rezyfr.dicoding.core.domain.usecase.MovieUseCase movieUseCase) {
        super();
    }
}