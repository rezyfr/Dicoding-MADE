package com.rezyfr.dicoding.made.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rezyfr.dicoding.core.base.BaseDataBindingFragment
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseDataBindingFragment<FragmentDetailBinding, DetailViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_detail

    override val viewModel: DetailViewModel by viewModels()

    private var isFavorite = false
    private var movieId = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            arguments?.let {
                movieId = DetailFragmentArgs.fromBundle(it).movieId
            }
            viewModel.getMovieDetail(movieId)
            viewModel.checkIfFavorited(movieId)

            btnFavorite.setOnClickListener {
                movie?.let {
                    if (isFavorite) viewModel.deleteFromFavorite(movieId)
                    else viewModel.addMovieToFavorite(it)
                }
            }
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun observeData() {
        viewModel.movieDetail.observe(viewLifecycleOwner, ::getMovieDetail)
        viewModel.isFavorite.observe(viewLifecycleOwner, ::checkIsFavorite)
    }

    private fun getMovieDetail(movie: Movie) {
        binding.movie = movie
    }

    private fun checkIsFavorite(isFavorite: Boolean) {
        this.isFavorite = isFavorite
        binding.btnFavorite.background =
            if (isFavorite) ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_favorite_filled
            )
            else ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_outlined)
    }

    override fun onBackPressed() {
        findNavController().navigateUp()
    }
}