package com.example.firstandroidapp.data.applist

import com.example.firstandroidapp.data.appsDto
import com.example.firstandroidapp.domain.applist.AppListRepository
import com.example.firstandroidapp.domain.applist.AppShortDetails
import kotlinx.coroutines.delay

class AppListMockRepositoryImpl(
    private val mapper: AppShortDetailsMapper,
    private val api: AppListApi,
) : AppListRepository{
    override suspend fun get(
        page: Int,
        pageSize: Int,
    ): List<AppShortDetails> {
        val appsDto = api.get(page, pageSize)
        val mappedApps = appsDto.map { mapper.map(it) }
        return mappedApps
    }

}