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

    private lateinit var _popularMovies: LiveData<PagingData<Movie>>
    val popularMovies: LiveData<PagingData<Movie>>
        get() = _popularMovies
    private lateinit var _nowPlayingMovies: LiveData<PagingData<Movie>>
    val nowPlayingMovies: LiveData<PagingData<Movie>>
        get() = _nowPlayingMovies

    init {
        getPopularMovies()
        getNowPlayingMovies()
    }

    private fun getPopularMovies() {
        _popularMovies =
            movieUseCase.discoverPopularMovies().cachedIn(viewModelScope).asLiveData()
    }

    private fun getNowPlayingMovies() {
        _nowPlayingMovies =
            movieUseCase.discoverNowPlayingMovies().cachedIn(viewModelScope).asLiveData()
    }
}