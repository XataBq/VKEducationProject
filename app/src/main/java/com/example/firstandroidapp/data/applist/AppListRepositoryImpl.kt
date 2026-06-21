package com.example.firstandroidapp.data.applist

import com.example.firstandroidapp.domain.applist.AppListRepository
import com.example.firstandroidapp.domain.applist.AppShortDetails

class AppListRepositoryImpl : AppListRepository {
    override suspend fun get(page: Int, pageSize: Int): List<AppShortDetails> {
        TODO("тут будет бэкэнд")
    }
}