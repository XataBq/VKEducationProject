package com.example.firstandroidapp.presentation.applist.content

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.domain.applist.AppShortDetails
import com.example.firstandroidapp.presentation.applist.components.AppListItem

//AppListScreen content on success
@Composable
fun AppListScreenSuccess(
    appList: List<AppShortDetails>,
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(appList) { app ->
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