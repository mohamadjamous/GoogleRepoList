package com.app.googlerepolist.domain.repository

import com.app.googlerepolist.data.remote.dto.RepoDetailDto
import com.app.googlerepolist.data.remote.dto.RepoDto

interface RepoRepository {

    suspend fun getRepos(): List<RepoDto>

    suspend fun getRepoBydId(repoId: String): RepoDetailDto
}