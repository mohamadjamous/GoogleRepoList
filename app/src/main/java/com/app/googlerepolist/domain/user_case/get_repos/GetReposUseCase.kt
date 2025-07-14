package com.app.googlerepolist.domain.user_case.get_repos

import com.app.googlerepolist.common.Resource
import com.app.googlerepolist.data.remote.dto.toRepo
import com.app.googlerepolist.domain.model.Repo
import com.app.googlerepolist.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetReposUseCase @Inject constructor(
    private val repository : RepoRepository
) {

    operator fun invoke() : Flow<Resource<List<Repo>>> = flow{

        try {

            emit(Resource.Loading<List<Repo>>())
            val repos = repository.getRepos().map { it.toRepo() }
            emit(Resource.Success<List<Repo>>(repos))
        }
        catch (e: HttpException){
            emit(Resource.Error<List<Repo>>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){
            emit(Resource.Error<List<Repo>>("Couldn't reach server. Check your internet connection"))
        }

    }
}