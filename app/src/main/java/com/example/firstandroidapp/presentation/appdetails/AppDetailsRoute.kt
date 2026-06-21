package com.example.firstandroidapp.presentation.appdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun AppDetailsRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    AppDetailsScreen(
        state = state,
        events = viewModel.events,
        onBackClick = onBackClick,
        getAppDetails = viewModel::getAppDetails,
        showUnderDevelopmentMessage = viewModel::showUnderDevelopmentMessage,
        collapseDescription = viewModel::collapseDescription,
        modifier = modifier,
    )
}