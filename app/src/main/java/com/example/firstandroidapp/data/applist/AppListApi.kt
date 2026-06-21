package com.example.firstandroidapp.data.applist

import com.example.firstandroidapp.data.appsDto
import kotlinx.coroutines.delay

class AppListApi {

    suspend fun get(
        page: Int,
        pageSize: Int = 10
    ): List<AppShortDetailsDto> {
        delay(1500L)

        val fromIndex = page * pageSize
        if (fromIndex >= appsDto.size) return emptyList()

        val toIndex = minOf(fromIndex + pageSize, appsDto.size)
        return appsDto.subList(fromIndex, toIndex)
    }
}