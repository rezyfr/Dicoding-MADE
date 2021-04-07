package com.rezyfr.dicoding.made.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.rezyfr.dicoding.core.base.BaseFragment
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding, MovieListViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_movie_list
    override val viewModel: MovieListViewModel by viewModels()
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListAdapter = MovieListAdapter {

        }

        binding.rvMovie.adapter = movieListAdapter

        viewModel.movieFlow.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                movieListAdapter.submitData(it)
            }
        }

        movieListAdapter.addLoadStateListener { loadState ->
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
//        TODO("Not yet implemented")
    }

//    private fun toMovieDetail(movie: Movie) {
//        val bundle = Bundle()
//        bundle.putParcelable("movie", movie)
//        findNavController().navigate(R.id.movie_detail_fragment, bundle)
//    }

}