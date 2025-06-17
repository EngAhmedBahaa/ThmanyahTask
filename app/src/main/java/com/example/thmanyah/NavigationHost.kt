package com.example.thmanyah

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.thmanyah.presentation.features.HomeRoutes
import com.example.thmanyah.presentation.features.home.ui.HomeSectionScreen

@Composable
fun NavigationHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = HomeRoutes.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(HomeRoutes.Home.route) { HomeSectionScreen(Modifier) }
       // composable(Screen.Search.route) { SearchScreen(Modifier) }
    }
}
