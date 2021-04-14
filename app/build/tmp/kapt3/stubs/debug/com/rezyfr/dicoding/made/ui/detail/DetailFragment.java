package com.rezyfr.dicoding.made.ui.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/rezyfr/dicoding/made/ui/detail/DetailFragment;", "Lcom/rezyfr/dicoding/core/base/BaseFragment;", "Lcom/rezyfr/dicoding/made/databinding/FragmentDetailBinding;", "Lcom/rezyfr/dicoding/made/ui/detail/DetailViewModel;", "()V", "isFavorited", "", "()Z", "setFavorited", "(Z)V", "viewModel", "getViewModel", "()Lcom/rezyfr/dicoding/made/ui/detail/DetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "layoutRes", "", "observeData", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class DetailFragment extends com.rezyfr.dicoding.core.base.BaseFragment<com.rezyfr.dicoding.made.databinding.FragmentDetailBinding, com.rezyfr.dicoding.made.ui.detail.DetailViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean isFavorited = false;
    
    @java.lang.Override()
    protected int layoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.rezyfr.dicoding.made.ui.detail.DetailViewModel getViewModel() {
        return null;
    }
    
    public final boolean isFavorited() {
        return false;
    }
    
    public final void setFavorited(boolean p0) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    public DetailFragment() {
        super();
    }
}