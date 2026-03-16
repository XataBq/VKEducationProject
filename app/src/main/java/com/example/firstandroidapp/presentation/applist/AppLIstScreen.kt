package com.example.firstandroidapp.presentation.applist

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firstandroidapp.presentation.applist.content.AppListScreenError
import com.example.firstandroidapp.presentation.applist.content.AppListScreenLoading
import com.example.firstandroidapp.presentation.applist.content.AppListScreenSuccess

@Composable
fun AppListScreen(
    uiState: AppListUiState,
    onAppClick: () -> Unit,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    //Общий layout для состояний
    AppListScreenLayout() {
        when (uiState) {
            AppListUiState.Loading -> {
                AppListScreenLoading()
            }

            is AppListUiState.Success -> {
                AppListScreenSuccess(
                    appList = uiState.apps,
                    onAppClick = onAppClick
                )
            }

            is AppListUiState.Error -> {
                AppListScreenError(
                    message = uiState.e.message ?: "Some error occured",
                    onRetryClick = onRetryClick
                )
            }
        }
    }
}
