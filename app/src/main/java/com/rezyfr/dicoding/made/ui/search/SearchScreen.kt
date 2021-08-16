package com.rezyfr.dicoding.made.ui.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@Composable
fun SearchScreen(searchViewModel: SearchViewModel = viewModel()) {
    Text(text = "Test")
}