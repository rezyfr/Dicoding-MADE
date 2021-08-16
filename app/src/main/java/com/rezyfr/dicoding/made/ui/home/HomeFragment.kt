package com.rezyfr.dicoding.made.ui.home

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.rezyfr.dicoding.core.base.BaseDataBindingFragment
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var upcomingMoviesAdapter: HomePagingAdapter
    private lateinit var nowPlayingMoviesAdapter: HomePagingAdapter

    private lateinit var broadcastReceiver: BroadcastReceiver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setAdapter()
    }

    private fun registerBroadCastReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                when (intent.action) {
                    Intent.ACTION_POWER_CONNECTED -> {
                        Toast.makeText(requireContext(), "Power Connected", Toast.LENGTH_SHORT).show()
                    }
                    Intent.ACTION_POWER_DISCONNECTED -> {
                        Toast.makeText(requireContext(), "Power Disconnected", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        requireActivity().registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        registerBroadCastReceiver()
    }

    override fun onStop() {
        super.onStop()
//        requireActivity().unregisterReceiver(broadcastReceiver)
    }

    private fun setToolbar() {
        binding?.toolbarMain?.apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_search -> {
                        val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment(null)
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
        }
    }

    private fun installChatModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(requireContext())
        val moduleChat = "favmovie"
        if (splitInstallManager.installedModules.contains(moduleChat)) {
            val action = HomeFragmentDirections.actionHomeFragmentToFavoriteFragment()
            findNavController().navigate(action)
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
        upcomingMoviesAdapter = HomePagingAdapter()
        upcomingMoviesAdapter.onItemClick = {
            toMovieDetail(it)
        }
        upcomingMoviesAdapter.addLoadStateListener { loadState ->
            loadStateListener(loadState)
        }
        binding?.rvUpcoming?.adapter = upcomingMoviesAdapter

        nowPlayingMoviesAdapter = HomePagingAdapter()
        nowPlayingMoviesAdapter.onItemClick = {
            toMovieDetail(it)
        }
        nowPlayingMoviesAdapter.addLoadStateListener { loadState ->
            loadStateListener(loadState)
        }
        binding?.rvPopular?.adapter = nowPlayingMoviesAdapter
    }

    private fun loadStateListener(loadState: CombinedLoadStates) {
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

    override fun observeData() {
//        viewModel.upcomingMovies.asLiveData().observe(viewLifecycleOwner, ::observeUpcomingList)
//        viewModel.nowPlayingMovies.asLiveData().observe(viewLifecycleOwner, ::observePopularList)
    }

    private fun observePopularList(list: PagingData<Movie>) {
        viewLifecycleOwner.lifecycleScope.launch {
            upcomingMoviesAdapter.submitData(list)
        }
    }

    private fun observeUpcomingList(list: PagingData<Movie>) {
        viewLifecycleOwner.lifecycleScope.launch {
            nowPlayingMoviesAdapter.submitData(list)
        }
    }

    private fun toMovieDetail(movie: Movie?) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie?.id ?: 0)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.rvPopular?.adapter = null
        binding?.rvUpcoming?.adapter = null
        binding?.scrollView?.removeAllViewsInLayout()
        binding?.scrollView?.removeAllViews()
    }

    override fun onBackPressed() {
        requireActivity().finishAfterTransition()
    }
}