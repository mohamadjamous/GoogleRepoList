package com.app.googlerepolist.presentation.repo_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.googlerepolist.common.Constants
import com.app.googlerepolist.common.Resource
import com.app.googlerepolist.domain.user_case.get_repo.GetRepoUseCase
import com.app.googlerepolist.domain.user_case.get_repos.GetReposUseCase
import com.app.googlerepolist.presentation.repo_list.RepoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel @Inject constructor(
    private val getRepoUseCase: GetRepoUseCase,
    safeStateHandle: SavedStateHandle
): ViewModel() {


    private val _state = mutableStateOf(RepoDetailState())
    val state: State<RepoDetailState> = _state


    init{
        safeStateHandle.get<String>(Constants.PARAM_REPO_ID)?.let{ repoId ->
            getRepo(repoId)
        }
    }


    private fun getRepo(repoId: String) {
        getRepoUseCase(repoId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RepoDetailState(repo = result.data)
                }
                is Resource.Error -> {
                    _state.value = RepoDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = RepoDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}