package com.rezyfr.dicoding.made.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.rezyfr.dicoding.core.base.BaseFragment
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setAdapter()
    }

    private fun setToolbar() {
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_search -> {
                    val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                    findNavController().navigate(action)
                }
            }
            false
        }
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter()
        homeAdapter.onItemClick = {
            toMovieDetail(it)
        }
        binding.rvMovie.adapter = homeAdapter

        homeAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            )
                handleLoading(true)
            else {
                handleLoading(false)

                // If we have an error, show a toast
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

    override fun observeData() {
        viewModel.movieFlow.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                val data = it
                homeAdapter.submitData(data)
            }
        }
    }

    private fun toMovieDetail(movie: Movie?) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        findNavController().navigate(R.id.detailFragment, bundle)
    }

}