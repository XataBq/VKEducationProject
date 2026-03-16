package com.example.firstandroidapp.data.applist

import com.example.firstandroidapp.data.apps
import com.example.firstandroidapp.data.appsDto
import kotlinx.coroutines.delay

class AppListApi {

    companion object {
        const val PAGE_SIZE = 10
    }

    suspend fun get(page: Int): List<AppShortDetailsDto> {
        delay(2000L)

        val fromIndex = page * PAGE_SIZE
        if (fromIndex >= apps.size) return emptyList()

        val toIndex = minOf(fromIndex + PAGE_SIZE, apps.size)
        return appsDto.subList(fromIndex, toIndex)
    }
}