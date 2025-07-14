package com.app.googlerepolist.presentation.repo_list

import com.app.googlerepolist.domain.model.Repo

data class RepoListState(
    val isLoading: Boolean = false,
    val repos: List<Repo> = emptyList(),
    val error: String = ""
)
