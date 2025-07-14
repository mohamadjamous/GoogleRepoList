package com.app.googlerepolist.data.remote

import com.app.googlerepolist.data.remote.dto.RepoDetailDto
import com.app.googlerepolist.data.remote.dto.RepoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleRepoApi {
    
    // Get Google Repo
    @GET("/orgs/google/repos")
    suspend fun getRepos() : List<RepoDto>

    // Get Repo Details
    @GET("repositories/{repoId}")
    suspend fun getRepoById(@Path("repoId") repoId: String): RepoDetailDto

}