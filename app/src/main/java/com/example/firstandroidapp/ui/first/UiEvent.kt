package com.example.firstandroidapp.ui.first

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
    data class OpenDialer(val number: String): UiEvent()
    data object ShareData: UiEvent()
}