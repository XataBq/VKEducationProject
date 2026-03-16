package com.example.firstandroidapp.presentation.applist

import com.example.firstandroidapp.domain.applist.AppShortDetails
import java.lang.Exception

sealed interface AppListUiState {
    data object Loading: AppListUiState
    data class Error(val e: Throwable): AppListUiState
    data class Success(
        val apps: List<AppShortDetails> = emptyList(),
        val endReached: Boolean = false,
        val isLoadingMore: Boolean = false
    ): AppListUiState
}