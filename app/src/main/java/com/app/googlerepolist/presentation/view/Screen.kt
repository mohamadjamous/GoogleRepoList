package com.app.googlerepolist.presentation.view

sealed class Screen(val route: String) {
    object RepoListScreen: Screen("repo_list_screen")
    object RepoDetailScreen: Screen("repo_detail_screen")
}