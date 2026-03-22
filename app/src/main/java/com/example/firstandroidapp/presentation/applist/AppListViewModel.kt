package com.example.firstandroidapp.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstandroidapp.R
import com.example.firstandroidapp.data.applist.AppListApi
import com.example.firstandroidapp.data.applist.AppListMockRepositoryImpl
import com.example.firstandroidapp.data.applist.AppShortDetailsMapper
import com.example.firstandroidapp.data.mapper.CategoryMapper
import com.example.firstandroidapp.domain.applist.AppListRepository
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

    private companion object {
        const val PAGE_SIZE: Int = 10
    }

    private var currentPage = 0

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _uiState.value = AppListUiState.Loading
            runCatching {
                appListRepository.get(
                    page = 0,
                    pageSize = PAGE_SIZE,
                )
            }.onSuccess { apps ->
                currentPage = 1
                _uiState.value = AppListUiState.Success(
                    apps = apps,
                    isLoadingMore = false,
                    endReached = apps.size < PAGE_SIZE
                )
            }.onFailure { e ->
                _uiState.value = AppListUiState.Error(e)
            }
        }
    }

    fun loadNextPage() {
        val state = _uiState.value
        if (state !is AppListUiState.Success) return
        if (state.isLoadingMore || state.endReached) return

        viewModelScope.launch {
            _uiState.value = state.copy(isLoadingMore = true)

            runCatching {
                appListRepository.get(
                    page = currentPage,
                    pageSize = PAGE_SIZE
                )
            }.onSuccess { newApps ->
                val updateState = (_uiState.value as? AppListUiState.Success) ?: return@onSuccess

                _uiState.value = updateState.copy(
                    apps = updateState.apps + newApps,
                    isLoadingMore = false,
                    endReached = newApps.size < PAGE_SIZE
                )

                if (newApps.isNotEmpty()) {
                    currentPage++
                }
            }.onFailure {
                val updatedState = (_uiState.value as? AppListUiState.Success) ?: return@onFailure

                _uiState.value = updatedState.copy(isLoadingMore = false)
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