package com.app.googlerepolist.presentation.repo_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.googlerepolist.common.Resource
import com.app.googlerepolist.common.UiEvent
import com.app.googlerepolist.domain.model.Repo
import com.app.googlerepolist.domain.user_case.get_repos.GetReposUseCase
import com.app.googlerepolist.presentation.repo_list.RepoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
): ViewModel() {

    private val _state = MutableStateFlow(RepoListState())
    val state: StateFlow<RepoListState> = _state.asStateFlow()

    var searchQuery by mutableStateOf("")
        private set

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()



    val filteredRepos: List<Repo>
        get() = if (searchQuery.isBlank()) state.value.repos
        else state.value.repos.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }

    init{
        getRepos()
    }


    fun getRepos() {
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

    fun onSearchQueryChanged(query: String) {
        searchQuery = query
    }

    fun onRepoClick(repoId: String) {
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.NavigateToDetail(repoId))
        }
    }


}