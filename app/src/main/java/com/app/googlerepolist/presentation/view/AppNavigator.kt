package com.app.googlerepolist.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.googlerepolist.presentation.repo_detail.view.RepoDetailScreen
import com.app.googlerepolist.presentation.repo_list.view.RepoListScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen {
                navController.navigate(Screen.RepoListScreen.route) {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
        composable(Screen.RepoListScreen.route) {
            RepoListScreen(navController)
        }
        composable(Screen.RepoDetailScreen.route + "/{repoId}") {
            RepoDetailScreen()
        }
    }
}