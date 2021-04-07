package com.rezyfr.dicoding.made.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/rezyfr/dicoding/made/ui/home/HomeFragment;", "Lcom/rezyfr/dicoding/core/base/BaseFragment;", "Lcom/rezyfr/dicoding/made/databinding/FragmentHomeBinding;", "Lcom/rezyfr/dicoding/made/ui/home/HomeViewModel;", "()V", "homeAdapter", "Lcom/rezyfr/dicoding/made/ui/home/HomeAdapter;", "viewModel", "getViewModel", "()Lcom/rezyfr/dicoding/made/ui/home/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "layoutRes", "", "observeData", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setAdapter", "setToolbar", "toMovieDetail", "movie", "Lcom/rezyfr/dicoding/core/domain/model/Movie;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class HomeFragment extends com.rezyfr.dicoding.core.base.BaseFragment<com.rezyfr.dicoding.made.databinding.FragmentHomeBinding, com.rezyfr.dicoding.made.ui.home.HomeViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.rezyfr.dicoding.made.ui.home.HomeAdapter homeAdapter;
    
    @java.lang.Override()
    protected int layoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.rezyfr.dicoding.made.ui.home.HomeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setToolbar() {
    }
    
    private final void setAdapter() {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    private final void toMovieDetail(com.rezyfr.dicoding.core.domain.model.Movie movie) {
    }
    
    public HomeFragment() {
        super();
    }
}