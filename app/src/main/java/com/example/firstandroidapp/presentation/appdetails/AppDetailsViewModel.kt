package com.example.firstandroidapp.presentation.appdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstandroidapp.data.appdetails.AppDetailsApi
import com.example.firstandroidapp.data.appdetails.AppDetailsMapper
import com.example.firstandroidapp.data.appdetails.AppDetailsMockRepositoryImpl
import com.example.firstandroidapp.data.mapper.CategoryMapper
import com.example.firstandroidapp.domain.Category
import com.example.firstandroidapp.domain.appdetails.AppDetails
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository
import com.example.firstandroidapp.presentation.navigation.Screen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val appDetailsRepository: AppDetailsRepository = AppDetailsMockRepositoryImpl(
        mapper = AppDetailsMapper(
            categoryMapper = CategoryMapper()
        ),
        api = AppDetailsApi(),
    )

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    val appId: String = checkNotNull(
        savedStateHandle[Screen.AppDetails.APP_ID]
    )

    init {
        getAppDetails()
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = true)
            } else {
                currentState
            }
        }
    }

    fun getAppDetails() {
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading

            runCatching {
                // Эмулируем загрузку с бэкенда
                delay(2.seconds)

                // В будущем заменим этот метод на вызов API.
                val appDetails = appDetailsRepository.get(appId)

                _state.value = AppDetailsState.Content(
                    appDetails = appDetails,
                    descriptionCollapsed = false,
                )
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }
}