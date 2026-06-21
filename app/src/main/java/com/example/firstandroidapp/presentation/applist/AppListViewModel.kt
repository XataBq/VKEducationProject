package com.example.firstandroidapp.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstandroidapp.R
import com.example.firstandroidapp.domain.applist.AppListRepository
import com.example.firstandroidapp.domain.util.DataResult
import com.example.firstandroidapp.presentation.extensions.toUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val appListRepository: AppListRepository
) : ViewModel() {

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
        _uiState.value = AppListUiState.Loading
        viewModelScope.launch {
            when(val result = appListRepository.get()) {
                is DataResult.Success -> {
                    _uiState.value = AppListUiState.Success(apps = result.data)
                }
                is DataResult.Error -> {
                    _uiState.value = AppListUiState.Error(
                        message = result.error.toUiText()
                    )
                }
            }

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