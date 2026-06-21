package com.example.firstandroidapp.presentation.applist

import com.example.firstandroidapp.domain.applist.AppShortDetails

sealed interface AppListUiState {
    data object Loading: AppListUiState
    data class Error(val message: UiText): AppListUiState
    data class Success(
        val apps: List<AppShortDetails> = emptyList(),
    ): AppListUiState
}