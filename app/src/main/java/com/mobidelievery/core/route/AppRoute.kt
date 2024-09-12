package com.mobidelievery.core.route

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobidelievery.module.detail.presenetation.DetailScreen
import com.mobidelievery.module.home.model.nowPlayingMovie
import com.mobidelievery.module.home.presenetation.HomeScreen
import com.mobidelievery.module.seat_selector.presenetation.SeatSelectorScreen

object AppRoute {

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun GenerateRoute(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = AppRouteName.Home,
        ) {
            composable(AppRouteName.Home) {
                HomeScreen(navController = navController)
            }
            composable("${AppRouteName.Detail}/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val movie = nowPlayingMovie.first{ it.id == id }

                DetailScreen(navController = navController, movie)
            }
            composable(AppRouteName.SeatSelector) {
                SeatSelectorScreen(navController = navController)
            }
        }
    }
}