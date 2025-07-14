package com.app.googlerepolist.domain.user_case.get_repo

import com.app.googlerepolist.common.Resource
import com.app.googlerepolist.data.remote.dto.toRepo
import com.app.googlerepolist.data.remote.dto.toRepoDetail
import com.app.googlerepolist.domain.model.Repo
import com.app.googlerepolist.domain.model.RepoDetail
import com.app.googlerepolist.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetRepoUseCase @Inject constructor(
    private val repository : RepoRepository
) {

    operator fun invoke(repoId: String) : Flow<Resource<RepoDetail>> = flow{

        try {
            emit(Resource.Loading())
            val repo = repository.getRepoBydId(repoId = repoId).toRepoDetail()
            emit(Resource.Success(repo))

        }
        catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }
}