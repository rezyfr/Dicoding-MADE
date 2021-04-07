package com.rezyfr.dicoding.made.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rezyfr.dicoding.core.base.BaseViewModel
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : BaseViewModel() {

    private lateinit var _movieFlow: LiveData<PagingData<Movie>>
    val movieFlow: LiveData<PagingData<Movie>>
        get() = _movieFlow

    init {
        discoverMovies()
    }

    private fun discoverMovies() {
        _movieFlow = movieUseCase.discoverMovies().cachedIn(viewModelScope).asLiveData()
    }

}