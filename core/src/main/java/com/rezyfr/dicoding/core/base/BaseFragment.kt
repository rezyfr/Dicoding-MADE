package com.rezyfr.dicoding.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.rezyfr.dicoding.core.R
import com.rezyfr.dicoding.core.utils.hideLoadingDialog
import com.rezyfr.dicoding.core.utils.loadingDialog
import com.rezyfr.dicoding.core.utils.showLoadingDialog
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseFragment<B : ViewBinding, VM : BaseViewModel> : Fragment() {
    @LayoutRes
    protected abstract fun layoutRes(): Int
    protected abstract val viewModel: VM
    var binding: B? = null

    private val backPressedDispatcher = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            this@BaseFragment.onBackPressed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        observeData()
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.apply {
            isLoading.observe(viewLifecycleOwner) {
                handleLoading(it)
            }
            errorMessage.observe(viewLifecycleOwner) {
                when (it) {
                    is SocketTimeoutException -> {
                        handleErrorMessage(getString(R.string.connect_timeout))
                    }
                    is ConnectException, is UnknownHostException -> {
                        handleErrorMessage(getString(R.string.no_internet_connection))
                    }
                    else -> {
                        handleErrorMessage(it.message)
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressedDispatcher)
    }

    open fun handleLoading(isLoading: Boolean) {
        if (isLoading) context?.showLoadingDialog() else hideLoadingDialog()
    }

    fun handleErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        hideLoadingDialog()
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cleanUp()
        backPressedDispatcher.remove()
        loadingDialog = null
        binding = null
    }

    abstract fun onBackPressed()
    abstract fun observeData()
    abstract fun getViewBinding(): B
    abstract fun cleanUp()
}