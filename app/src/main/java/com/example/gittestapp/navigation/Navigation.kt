package com.example.gittestapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gittestapp.ui.screens.SplashScreen
import com.example.gittestapp.viewmodel.SchoolListViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SPLASH_SCREEN.name) {

        composable(Route.SPLASH_SCREEN.name) {
            val schoolListViewModel = hiltViewModel<SchoolListViewModel>()
            //val schoolListViewModel = hiltViewModel<SchoolDe>()
            SplashScreen(navController, schoolListViewModel)
        }

    }

}