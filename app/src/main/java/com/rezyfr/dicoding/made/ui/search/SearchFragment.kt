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

@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()
    override fun layoutRes(): Int = R.layout.fragment_search
    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
    private lateinit var searchPagingAdapter: SearchPagingAdapter

    override fun observeData() {
        viewModel.searchResult.observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                if (it.toString().isNotEmpty()) {
                    searchPagingAdapter.submitData(it)
                    binding?.rvSearch?.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        binding?.apply {
            svMovie.isFocusable = true
            svMovie.isIconified = false
            svMovie.requestFocusFromTouch()
            svMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let { viewModel.setSearchQuery(it) }
                    return true
                }
            })
        }
    }

    private fun setAdapter() {
        searchPagingAdapter = SearchPagingAdapter()
        searchPagingAdapter.onItemClick = {
            toMovieDetail(it)
        }
        binding?.rvSearch?.adapter = searchPagingAdapter

        searchPagingAdapter.addLoadStateListener { loadState ->
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
        val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(movie?.id ?: 0)
        findNavController().navigate(action)
    }

    override fun cleanUp() {
        binding?.rvSearch?.adapter = null
        binding?.svMovie?.setOnQueryTextListener(null)
    }

    override fun onBackPressed() {
        findNavController().navigateUp()
    }
}