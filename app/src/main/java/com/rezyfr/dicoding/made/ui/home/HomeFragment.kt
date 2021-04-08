package com.rezyfr.dicoding.made.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.rezyfr.dicoding.core.base.BaseFragment
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var homePagingAdapter: HomePagingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setAdapter()
    }

    private fun setToolbar() {
        binding.toolbarMain.apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_search -> {
                        val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                        findNavController().navigate(action)
                    }
                    R.id.menu_favorite -> {
                        try {
                            installChatModule()
                        } catch (e: Exception) {
                            Toast.makeText(activity, "Module not found", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                false
            }
            title = "Movie App"
        }
    }

    private fun installChatModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(requireContext())
        val moduleChat = "favmovie"
        if (splitInstallManager.installedModules.contains(moduleChat)) {
            val uri = Uri.parse("submission://favorite")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleChat)
                .build()
            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    Toast.makeText(activity, "Success installing module", Toast.LENGTH_SHORT).show()
                    val uri = Uri.parse("submission://favorite")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
                .addOnFailureListener {
                    Toast.makeText(activity, "Error installing module", Toast.LENGTH_SHORT).show()
                    Timber.e(it)
                }
        }
    }

    private fun setAdapter() {
        homePagingAdapter = HomePagingAdapter()
        homePagingAdapter.onItemClick = {
            toMovieDetail(it)
        }
        binding.rvMovie.adapter = homePagingAdapter

        homePagingAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            )
                handleLoading(true)
            else {
                handleLoading(false)

                // If we have an error, show a toast
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    handleErrorMessage(it.error.toString())
                }
            }
        }
    }

    override fun observeData() {
        viewModel.movieFlow.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                val data = it
                homePagingAdapter.submitData(data)
            }
        }
    }

    private fun toMovieDetail(movie: Movie?) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        findNavController().navigate(R.id.detailFragment, bundle)
    }

}