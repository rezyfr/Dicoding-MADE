package com.rezyfr.dicoding.made.ui.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rezyfr.dicoding.core.base.BaseViewModel
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : BaseViewModel() {

    private lateinit var _topRatedMovies: Flow<PagingData<Movie>>
    val topRatedMovies: Flow<PagingData<Movie>>
        get() = _topRatedMovies
    private lateinit var _popularMovies: Flow<PagingData<Movie>>
    val popularMovies: Flow<PagingData<Movie>>
        get() = _popularMovies

    init {
        getUpcomingMovies()
        getPopularMovies()
    }

    private fun getPopularMovies() {
        _popularMovies =
            movieUseCase.discoverPopularMovies().cachedIn(viewModelScope)
    }

    private fun getUpcomingMovies() {
        _topRatedMovies =
            movieUseCase.discoverTopRatedMovies().cachedIn(viewModelScope)
    }
}