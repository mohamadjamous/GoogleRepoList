package com.app.googlerepolist.data.repository

import com.app.googlerepolist.data.remote.GoogleRepoApi
import com.app.googlerepolist.data.remote.dto.RepoDetailDto
import com.app.googlerepolist.data.remote.dto.RepoDto
import com.app.googlerepolist.domain.repository.RepoRepository
import javax.inject.Inject

class RepoRepositoryImpl(
    private val api: GoogleRepoApi
) : RepoRepository {

    private var repoCache: List<RepoDto>? = null

    override suspend fun getRepos(): List<RepoDto> {
        repoCache?.let {
            return it
        }

        val repos = api.getRepos()
        repoCache = repos
        return repos
    }

    override suspend fun getRepoBydId(id: String): RepoDetailDto {
        return api.getRepoById(id)
    }

    fun clearCache() {
        repoCache = null
    }
}
