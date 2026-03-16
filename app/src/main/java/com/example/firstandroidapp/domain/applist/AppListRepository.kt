package com.example.firstandroidapp.domain.applist

interface AppListRepository {
    suspend fun get(): List<AppShortDetails>
}