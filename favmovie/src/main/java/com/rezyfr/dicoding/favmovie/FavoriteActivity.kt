package com.rezyfr.dicoding.favmovie

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.rezyfr.dicoding.core.base.BaseActivity
import com.rezyfr.dicoding.favmovie.databinding.ActivityFavoriteBinding
import com.rezyfr.dicoding.favmovie.di.DaggerFavoriteComponent
import com.rezyfr.dicoding.favmovie.utils.ViewModelFactory
import com.rezyfr.dicoding.made.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : BaseActivity<FavoriteViewModel, ActivityFavoriteBinding>() {
    @Inject
    lateinit var factory: ViewModelFactory
    override val viewModel: FavoriteViewModel by viewModels {
        factory
    }
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun contentView(): Int = R.layout.activity_favorite

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarFav)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewModel.favoriteFlow.observe(this, {
            if(it.isNotEmpty()) {
                favoriteAdapter.setData(it)
                binding.rvSearch.visibility = View.VISIBLE
                binding.containerNoFav.visibility = View.GONE
            }
        })
    }

    override fun setupView() {
        favoriteAdapter = FavoriteAdapter(arrayListOf())
        binding.rvSearch.adapter = favoriteAdapter

    }
}