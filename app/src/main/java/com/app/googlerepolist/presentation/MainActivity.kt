package com.app.googlerepolist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.googlerepolist.presentation.repo_detail.components.RepoDetailScreen
import com.app.googlerepolist.presentation.repo_list.RepoListScreen
import com.app.googlerepolist.presentation.ui.theme.GoogleRepoListTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            GoogleRepoListTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.RepoListScreen.route
                    ) {
                        composable(
                            route = Screen.RepoListScreen.route
                        ) {
                            RepoListScreen(navController)
                        }
                        composable(
                            route = Screen.RepoDetailScreen.route + "/{repoId}"
                        ) {
                            RepoDetailScreen()
                        }
                    }
                }

            }
        }
    }
}
