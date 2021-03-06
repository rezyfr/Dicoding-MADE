package com.rezyfr.dicoding.made.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rezyfr.dicoding.core.base.BaseViewModel
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : BaseViewModel() {

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite
    private var _movieDetail = MutableLiveData<Movie>()
    val movieDetail: LiveData<Movie> = _movieDetail

    fun getMovieDetail(id: Int) {
        viewModelScope.launch {
            useCase.getMovieDetail(id).collect {
                _movieDetail.value = it
            }
        }
    }

    fun addMovieToFavorite(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.setFavoriteMovie(movie)
        }
        _isFavorite.value = true
    }

    fun checkIfFavorited(id: Int?) {
        viewModelScope.launch {
            val status = withContext(Dispatchers.IO) { useCase.checkIfMovieFavorited(id) }
            _isFavorite.value = status
        }
    }

    fun deleteFromFavorite(id: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.deleteMovieFromFavorite(id)
        }
        _isFavorite.value = false
    }
}