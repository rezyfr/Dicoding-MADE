package com.rezyfr.dicoding.favmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rezyfr.dicoding.core.base.BaseViewModel
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val movieUseCase: MovieUseCase
) : BaseViewModel() {

    private lateinit var _favoriteFlow: LiveData<List<Movie>>
    val favoriteFlow: LiveData<List<Movie>>
        get() = _favoriteFlow

    init {
        getFavoriteList()
    }

    private fun getFavoriteList() {
        viewModelScope.launch {
            _favoriteFlow = movieUseCase.getFavoriteMovies().asLiveData()
        }
    }
}
