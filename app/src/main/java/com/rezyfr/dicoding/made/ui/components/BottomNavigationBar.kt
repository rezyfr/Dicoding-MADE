package com.rezyfr.dicoding.made.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rezyfr.dicoding.made.MovieScreen
import com.rezyfr.dicoding.made.ui.theme.AppBarBg
import com.rezyfr.dicoding.made.ui.theme.Green500

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val screens = listOf(
        MovieScreen.Home,
        MovieScreen.Search,
        MovieScreen.Favorite
    )
    BottomNavigation(contentColor = Green500, backgroundColor = AppBarBg) {
        screens.forEach { screen ->
            screen.icon?.let {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = it,
                            contentDescription = screen.name
                        )
                    },
                    selected = currentRoute == screen.name,
                    selectedContentColor = Green500,
                    unselectedContentColor = Color.White,
                    onClick = {
                        navController.navigate(screen.name) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}