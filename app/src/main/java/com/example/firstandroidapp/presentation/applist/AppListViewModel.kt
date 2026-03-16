package com.example.firstandroidapp.presentation.applist

import android.os.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstandroidapp.data.apps
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<AppListUiState>(AppListUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init{
        loadApps()
    }

    fun loadApps(){
        viewModelScope.launch {
            _uiState.value = AppListUiState.Loading
            delay(2000L)
            _uiState.value = AppListUiState.Success(apps)
        }
    }
}