package com.example.firstandroidapp.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.firstandroidapp.R
import kotlinx.coroutines.flow.Flow

@Composable
fun AppDetailsScreen(
    state: AppDetailsState,
    events: Flow<AppDetailsEvent>,
    onBackClick: () -> Unit,
    getAppDetails: () -> Unit,
    showUnderDevelopmentMessage: () -> Unit,
    collapseDescription: () -> Unit,
    toggleWishList: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = modifier.background(MaterialTheme.colorScheme.surface)
    ) { contentPadding ->
        when (val currentState = state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { getAppDetails() },
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = currentState,
                    onBackClick = onBackClick,
                    onShareClick = {
                        showUnderDevelopmentMessage()
                    },
                    onInstallClick = {
                        showUnderDevelopmentMessage()
                    },
                    onReadMoreClick = {
                        collapseDescription()
                    },
                    onDeveloperClick = {
                        showUnderDevelopmentMessage()
                    },
                    onFavoriteClick = toggleWishList,
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppDetailsEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val underDevelopementText = stringResource(R.string.under_development)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppDetailsEvent.UnderDevelopment -> {
                    snackbarHostState.showSnackbar(underDevelopementText)
                }
            }
        }
    }
}