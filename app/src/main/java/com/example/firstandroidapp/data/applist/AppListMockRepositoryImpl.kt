package com.example.firstandroidapp.data.applist

import com.example.firstandroidapp.domain.applist.AppListRepository
import com.example.firstandroidapp.domain.applist.AppShortDetails
import javax.inject.Inject

class AppListMockRepositoryImpl @Inject constructor(
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