package com.example.firstandroidapp.presentation.applist.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.domain.applist.AppShortDetails
import com.example.firstandroidapp.presentation.applist.components.AppListItem
import kotlinx.coroutines.flow.distinctUntilChanged

//AppListScreen content on success
@Composable
fun AppListScreenSuccess(
    appList: List<AppShortDetails>,
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberSaveable(saver = LazyListState.Saver) {
        LazyListState()
    }

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(
            items = appList,
            key = { app -> app.id }) { app ->
            AppListItem(
                app = app,
                onClick = onAppClick
            )
            HorizontalDivider(
                modifier = Modifier.padding(start = 96.dp),
                color = Color.LightGray
            )
        }
    }
}