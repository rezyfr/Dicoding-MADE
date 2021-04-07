package com.rezyfr.dicoding.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseViewModel : ViewModel() {

    val isLoading by lazy { MutableLiveData(false) }
    val errorMessage by lazy { MutableLiveData<Throwable>() }

    open suspend fun onError(throwable: Throwable?) {
        withContext(Dispatchers.Main) {
            throwable?.let {
                showError(it)
            }
            hideLoading()
        }
    }

    open fun showError(e: Throwable) {
        errorMessage.value = e
    }

    fun showLoading() {
        isLoading.value = true
    }

    fun hideLoading() {
        isLoading.value = false
    }
}