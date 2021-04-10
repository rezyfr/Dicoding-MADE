package com.rezyfr.dicoding.made.ui

import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.rezyfr.dicoding.core.base.BaseActivity
import com.rezyfr.dicoding.core.base.BaseViewModel
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    override fun contentView() = R.layout.activity_main

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override val viewModel by viewModels<MainViewModel>()

    private lateinit var navHostFragment: NavHostFragment

    override fun setupView() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        setupToolbar()
        setupNavigation()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarMain)
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.main_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

}