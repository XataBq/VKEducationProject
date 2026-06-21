package com.example.firstandroidapp.presentation.applist

sealed interface AppListUiEvents {
    data class ShowSnackbar(val message: UiText): AppListUiEvents
}