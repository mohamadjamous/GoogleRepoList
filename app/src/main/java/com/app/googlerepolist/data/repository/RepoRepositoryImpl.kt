package com.app.googlerepolist.data.repository

import com.app.googlerepolist.data.remote.GoogleRepoApi
import com.app.googlerepolist.data.remote.dto.RepoDetailDto
import com.app.googlerepolist.data.remote.dto.RepoDto
import com.app.googlerepolist.domain.repository.RepoRepository
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val api : GoogleRepoApi
) : RepoRepository {

    override suspend fun getRepos(): List<RepoDto> {
        return api.getRepos()
    }

    override suspend fun getRepoBydId(repoId: String): RepoDetailDto {
        return api.getRepoById(repoId = repoId)
    }
}