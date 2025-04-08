package com.example.gittestapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gittestapp.ui.screens.SchoolDetailsScreen
import com.example.gittestapp.ui.screens.SchoolListScreen
import com.example.gittestapp.ui.screens.SplashScreen
import com.example.gittestapp.viewmodel.SchoolDetailsViewModel
import com.example.gittestapp.viewmodel.SchoolListViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SPLASH_SCREEN.name) {

        composable(Route.SPLASH_SCREEN.name) {
            SplashScreen(navController)
        }

        composable(Route.SCHOOL_LIST.name) {
            val schoolListViewModel = hiltViewModel<SchoolListViewModel>()
            SchoolListScreen(navController, schoolListViewModel)
        }

        composable(Route.SCHOOL_DETAILS.name + "/{schoolId}") { navBackStack ->
            val schoolId = navBackStack.arguments?.getInt("schoolId") ?: 0
            val schoolDetailsViewModel = hiltViewModel<SchoolDetailsViewModel>()
            SchoolDetailsScreen(schoolDetailsViewModel, schoolId)
        }

    }

}
