package com.app.googlerepolist.common

sealed class UiEvent {
    data class NavigateToDetail(val repoId: String) : UiEvent()
    data class ShowSnackBar(val message: String) : UiEvent()
}