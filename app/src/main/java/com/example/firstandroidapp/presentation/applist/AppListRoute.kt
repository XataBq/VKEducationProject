package com.example.firstandroidapp.presentation.applist

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstandroidapp.data.apps
import kotlinx.coroutines.launch

@Composable
fun AppListRoute(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppListScreen(
        uiState = uiState,
        onAppClick = onAppClick,
        onRetryClick = viewModel::loadApps,
        modifier = modifier
    )
}