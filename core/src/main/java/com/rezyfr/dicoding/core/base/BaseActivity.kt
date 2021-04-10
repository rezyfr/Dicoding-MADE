package com.rezyfr.dicoding.core.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.rezyfr.dicoding.core.R
import com.rezyfr.dicoding.core.utils.hideLoadingDialog
import com.rezyfr.dicoding.core.utils.showLoadingDialog
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseActivity<VM : BaseViewModel, B : ViewBinding> : AppCompatActivity() {

    @LayoutRes
    protected abstract fun contentView(): Int
    protected abstract val viewModel: VM
    protected abstract fun setupView()
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        setupView()
        observeErrorEvent()
    }

    private fun observeErrorEvent() {
        viewModel.apply {
            isLoading.observe(this@BaseActivity) {
                handleLoading(it)
            }
            errorMessage.observe(this@BaseActivity) {
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

    open fun handleLoading(isLoading: Boolean) {
        if (isLoading) showLoading() else hideLoading()
    }

    private fun showLoading() {
        showLoadingDialog()
    }

    private fun hideLoading() {
        hideLoadingDialog()
    }

    private fun handleErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        hideLoading()
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    abstract fun getViewBinding(): B
}