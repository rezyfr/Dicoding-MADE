package com.rezyfr.dicoding.made.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.rezyfr.dicoding.made.MovieScreen
import com.rezyfr.dicoding.made.ui.home.HomeScreen
import com.rezyfr.dicoding.made.ui.theme.MovieTheme

class MovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp()
        }
    }
}

@Composable
fun MovieApp() {
    val navController = rememberNavController()
    MovieTheme {
        Scaffold(
        ) { innerPadding ->
            MovieNavHost(navController, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun MovieNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = MovieScreen.Splash.name,
        modifier = modifier
    ) {
        composable(MovieScreen.Splash.name) {
            SplashScreen(
                onTimeFinished = { navController.navigate(MovieScreen.Home.name) }
            )
        }
        composable(MovieScreen.Home.name) {
            HomeScreen()
        }
    }
}