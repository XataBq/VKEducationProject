package com.example.firstandroidapp.presentation.applist

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.firstandroidapp.R
import com.example.firstandroidapp.presentation.applist.content.AppListScreenError
import com.example.firstandroidapp.presentation.applist.content.AppListScreenLoading
import com.example.firstandroidapp.presentation.applist.content.AppListScreenSuccess

@Composable
fun AppListScreen(
    uiState: AppListUiState,
    snackbarHostState: SnackbarHostState,
    onLogoClick: () -> Unit,
    onAppClick: (String) -> Unit,
    onLoadMore: () -> Unit,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    //Общий layout для состояний
    AppListScreenLayout(
        snackbarHostState = snackbarHostState,
        onLogoClick = onLogoClick
    ) {
        when (uiState) {
            AppListUiState.Loading -> {
                AppListScreenLoading()
            }

            is AppListUiState.Success -> {
                AppListScreenSuccess(
                    appList = uiState.apps,
                    isLoadingMore = uiState.isLoadingMore,
                    onAppClick = onAppClick,
                    onLoadMore = onLoadMore,
                )
            }

            is AppListUiState.Error -> {
                AppListScreenError(
                    message = uiState.e.message ?: stringResource(R.string.error_unknown),
                    onRetryClick = onRetryClick
                )
            }
        }
    }
}
