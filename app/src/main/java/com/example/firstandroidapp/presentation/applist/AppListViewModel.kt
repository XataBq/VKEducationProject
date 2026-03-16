package com.example.firstandroidapp.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstandroidapp.R
import com.example.firstandroidapp.data.apps
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<AppListUiState>(AppListUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _uiEvents = MutableSharedFlow<AppListUiEvents>(
        replay = 0,
        extraBufferCapacity = 1
    )
    val events = _uiEvents.asSharedFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _uiState.value = AppListUiState.Loading
            delay(2000L)
            _uiState.value = AppListUiState.Success(apps)
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _uiEvents.tryEmit(
                AppListUiEvents.ShowSnackbar(
                    UiText.StringResource(R.string.logo_click_message)
                )
            )
        }
    }

}