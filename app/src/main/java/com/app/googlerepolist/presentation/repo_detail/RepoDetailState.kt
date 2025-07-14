package com.app.googlerepolist.presentation.repo_detail

import com.app.googlerepolist.domain.model.Repo
import com.app.googlerepolist.domain.model.RepoDetail

data class RepoDetailState(
    val isLoading: Boolean = false,
    val repo: RepoDetail? = null,
    val error: String = ""
)
