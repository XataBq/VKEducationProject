package com.example.firstandroidapp.domain.applist

import com.example.firstandroidapp.domain.util.DataResult

interface AppListRepository {
    suspend fun get(): DataResult<List<AppShortDetails>>
}