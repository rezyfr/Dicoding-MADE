package com.rezyfr.dicoding.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseViewModel : ViewModel() {

    val isLoading by lazy { MutableLiveData(false) }
    val errorMessage by lazy { MutableLiveData<Throwable>() }

    open fun showError(e: Throwable) {
        errorMessage.value = e
    }

    private fun hideLoading() {
        isLoading.value = false
    }
}