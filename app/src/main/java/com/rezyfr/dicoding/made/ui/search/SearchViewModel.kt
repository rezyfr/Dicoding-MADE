package com.rezyfr.dicoding.made.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rezyfr.dicoding.core.base.BaseViewModel
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class SearchViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : BaseViewModel() {

    private lateinit var _searchResult: LiveData<PagingData<Movie>>
//    val searchResult: LiveData<PagingData<Movie>>
//        get() = _searchResult

    private fun searchMovies(query: String) {
        _searchResult = movieUseCase.searchMovies(query).cachedIn(viewModelScope).asLiveData()
    }

    private val queryChannel = ConflatedBroadcastChannel<String>()

    fun setSearchQuery(search: String) {
        queryChannel.offer(search)
    }

    @FlowPreview
    val searchResult = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }.flatMapLatest {
            movieUseCase.searchMovies(it)
        }.asLiveData()
}