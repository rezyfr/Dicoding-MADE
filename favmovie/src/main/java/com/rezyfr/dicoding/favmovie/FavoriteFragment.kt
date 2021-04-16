package com.rezyfr.dicoding.favmovie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rezyfr.dicoding.core.base.BaseFragment
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.favmovie.databinding.FragmentFavoriteBinding
import com.rezyfr.dicoding.favmovie.di.DaggerFavoriteComponent
import com.rezyfr.dicoding.favmovie.utils.ViewModelFactory
import com.rezyfr.dicoding.made.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {
    @Inject
    lateinit var factory: ViewModelFactory
    override val viewModel: FavoriteViewModel by viewModels {
        factory
    }
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun getViewBinding() = FragmentFavoriteBinding.inflate(layoutInflater)
    override fun layoutRes(): Int = R.layout.fragment_favorite

    override fun observeData() {
        viewModel.favoriteFlow.observe(this, {
            if (it.isNotEmpty()) {
                favoriteAdapter.setData(it)
                binding.rvSearch.visibility = View.VISIBLE
                binding.ivNoData.visibility = View.GONE
                binding.tvNoData.visibility = View.GONE
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteAdapter = FavoriteAdapter(arrayListOf())
        favoriteAdapter.onItemClick = {
            toMovieDetail(it)
        }
        binding.rvSearch.adapter = favoriteAdapter
    }


    private fun toMovieDetail(movie: Movie?) {
        movie?.let {
            val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(movie.id ?: 0)
            findNavController().navigate(action)
        }
    }
}