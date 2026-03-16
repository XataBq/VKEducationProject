package com.example.firstandroidapp.domain.applist

interface AppListRepository {
    suspend fun get(
        page: Int,
        pageSize: Int,
    ): List<AppShortDetails>
}