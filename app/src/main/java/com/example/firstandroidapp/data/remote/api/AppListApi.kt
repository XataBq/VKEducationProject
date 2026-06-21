package com.example.firstandroidapp.data.remote.api

import com.example.firstandroidapp.data.remote.dto.AppShortDetailsDto

import retrofit2.http.GET


interface AppListApi {
    @GET("catalog")
    suspend fun getList(): List<AppShortDetailsDto>
}

//class AppListApi @Inject constructor(){
//
//    suspend fun get(
//        page: Int,
//        pageSize: Int = 10
//    ): List<AppShortDetailsDto> {
//        delay(1500L)
//
//        val fromIndex = page * pageSize
//        if (fromIndex >= appsDto.size) return emptyList()
//
//        val toIndex = minOf(fromIndex + pageSize, appsDto.size)
//        return appsDto.subList(fromIndex, toIndex)
//    }
//}