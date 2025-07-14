package com.app.googlerepolist.presentation

sealed class Screen(val route: String) {
    object RepoListScreen: Screen("repo_list_screen")
    object RepoDetailScreen: Screen("repo_detail_screen")
}