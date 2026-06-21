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
    isLoadingMore: Boolean,
    endReached: Boolean,
    onAppClick: (String) -> Unit,
    onLoadMore: () -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberSaveable(saver = LazyListState.Saver) {
        LazyListState()
    }

    LaunchedEffect(listState, appList.size, isLoadingMore, endReached) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        }
            .distinctUntilChanged()
            .collect { lastVisibleIndex ->
                if (lastVisibleIndex == null) return@collect
                if (isLoadingMore || endReached) return@collect

                val shouldLoadMore = lastVisibleIndex >= appList.lastIndex - 2
                if (shouldLoadMore) {
                    onLoadMore()
                }
            }
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

        if (isLoadingMore) {
            item(key = "loading_more") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}