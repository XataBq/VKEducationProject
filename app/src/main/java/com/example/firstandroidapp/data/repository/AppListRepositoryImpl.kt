package com.example.firstandroidapp.data.repository

import retrofit2.HttpException
import com.example.firstandroidapp.data.mapper.AppShortDetailsMapper
import com.example.firstandroidapp.data.remote.api.AppListApi
import com.example.firstandroidapp.domain.applist.AppListRepository
import com.example.firstandroidapp.domain.applist.AppShortDetails
import com.example.firstandroidapp.domain.util.AppError
import com.example.firstandroidapp.domain.util.DataResult
import okio.IOException
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor(
    private val api: AppListApi,
    private val mapper: AppShortDetailsMapper
) : AppListRepository {
    override suspend fun get(): DataResult<List<AppShortDetails>> {
        return try {
            val apps = api.getList().map { mapper.map(it) }
            DataResult.Success(apps)
        } catch (e: IOException) {
            DataResult.Error(AppError.Network)
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> DataResult.Error(AppError.Unauthorized)
                404 -> DataResult.Error(AppError.NotFound)
                in 500..599 -> DataResult.Error(AppError.Server)
                else -> DataResult.Error(AppError.Unknown(e.message()))
            }
        } catch (e: Exception) {
            DataResult.Error(AppError.Unknown(e.message))
        }
    }
}