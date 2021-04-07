package com.rezyfr.dicoding.made.ui.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.rezyfr.dicoding.core.base.BaseFragment
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import timber.log.Timber

@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()
    override fun layoutRes(): Int = R.layout.fragment_search
    private lateinit var searchAdapter: SearchAdapter

    override fun observeData() {
        binding.svMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { viewModel.setSearchQuery(it) }
                return true
            }
        })
        viewModel.searchResult.observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                Timber.d("MovieSearch: $it")
                val data = it
                searchAdapter.submitData(data)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.svMovie.isFocusable = true
        binding.svMovie.isIconified = false
        binding.svMovie.requestFocusFromTouch()
        setAdapter()
    }

    private fun setAdapter() {
        searchAdapter = SearchAdapter()
        searchAdapter.onItemClick = {
            toMovieDetail(it)
        }
        binding.rvSearch.adapter = searchAdapter

        searchAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            )
                handleLoading(true)
            else {
                handleLoading(false)

                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    handleErrorMessage(it.error.toString())
                }
            }
        }
    }

    private fun toMovieDetail(movie: Movie?) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        findNavController().navigate(R.id.detailFragment, bundle)
    }
}