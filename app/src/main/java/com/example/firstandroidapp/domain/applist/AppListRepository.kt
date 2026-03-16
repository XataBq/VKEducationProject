package com.example.firstandroidapp.domain.applist

interface AppListRepository {
    fun get(): List<AppShortDetails>
}