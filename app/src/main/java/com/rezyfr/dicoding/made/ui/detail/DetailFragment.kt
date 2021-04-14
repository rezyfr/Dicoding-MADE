package com.rezyfr.dicoding.made.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rezyfr.dicoding.core.base.BaseFragment
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_detail

    override val viewModel: DetailViewModel by viewModels()

    var isFavorited = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            arguments?.let {
                val movie = DetailFragmentArgs.fromBundle(it).movie
                binding.movie = movie
            }
            movie?.let { movie ->
                viewModel.checkIfFavorited(movie.id)

                btnFavorite.setOnClickListener {
                    if (isFavorited) viewModel.deleteFromFavorite(movie.id)
                    else viewModel.addMovieToFavorite(movie)
                }
            }
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun observeData() {
        viewModel.isFavorited.observe(viewLifecycleOwner, {
            isFavorited = it
            binding.btnFavorite.background =
                if (it) ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_filled)
                else ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_outlined)
        })
    }

}