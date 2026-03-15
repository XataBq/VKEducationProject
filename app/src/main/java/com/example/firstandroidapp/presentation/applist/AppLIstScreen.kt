package com.example.firstandroidapp.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.data.apps

@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
        Box(modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AppListHeader()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                ) {
                    LazyColumn {
                        items(apps) { app ->
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
            }
        }
    }
