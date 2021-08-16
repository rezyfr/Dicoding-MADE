package com.rezyfr.dicoding.made.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rezyfr.dicoding.made.MovieScreen
import com.rezyfr.dicoding.made.ui.components.BottomNavigationBar
import com.rezyfr.dicoding.made.ui.components.HomeAppBar
import com.rezyfr.dicoding.made.ui.home.HomeScreen
import com.rezyfr.dicoding.made.ui.home.HomeViewModel
import com.rezyfr.dicoding.made.ui.search.SearchScreen
import com.rezyfr.dicoding.made.ui.search.SearchViewModel
import com.rezyfr.dicoding.made.ui.theme.Green500
import com.rezyfr.dicoding.made.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi

@AndroidEntryPoint
class MovieActivity : ComponentActivity() {
    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp()
        }
    }
}

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@ExperimentalAnimationApi
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    val (appBarVisible, setVisibility) = remember { mutableStateOf(false) }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    navController.addOnDestinationChangedListener { controller, _, _ ->
        setVisibility(controller.currentDestination != navController.findDestination(MovieScreen.Splash.name))
    }
    MovieTheme {
        Scaffold(
            topBar = {
                if (appBarVisible) HomeAppBar()
            },
            scaffoldState = scaffoldState,
            bottomBar = {
                if (appBarVisible) BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            MovieNavHost(navController, modifier = Modifier.padding(innerPadding))
        }
    }
}

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@Composable
fun MovieNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = MovieScreen.Splash.name,
        modifier = modifier
    ) {
        composable(MovieScreen.Splash.name) {
            SplashScreen(
                onTimeFinished = {
                    navController.navigate(MovieScreen.Home.name) {
                        popUpTo(MovieScreen.Splash.name) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(MovieScreen.Home.name) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel)
        }
        composable(MovieScreen.Search.name) {
            val viewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(viewModel)
        }
        composable(MovieScreen.Favorite.name) {
            val viewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(viewModel)
        }
    }
}