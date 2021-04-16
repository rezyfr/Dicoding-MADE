package com.rezyfr.dicoding.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    val isLoading by lazy { MutableLiveData(false) }
    val errorMessage by lazy { MutableLiveData<Throwable>() }

}