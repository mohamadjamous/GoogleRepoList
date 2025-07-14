package com.app.googlerepolist.presentation.repo_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.googlerepolist.common.Resource
import com.app.googlerepolist.domain.user_case.get_repos.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
): ViewModel() {


    private val _state = mutableStateOf(RepoListState())
    val state: State<RepoListState> = _state


    init{
        getRepos()
    }


    private fun getRepos() {
        getReposUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RepoListState(repos = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = RepoListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = RepoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}