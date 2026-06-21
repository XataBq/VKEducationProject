package com.example.firstandroidapp.data.repository

import com.example.firstandroidapp.data.mapper.AppDetailsMapper
import com.example.firstandroidapp.data.remote.api.AppDetailsApi
import com.example.firstandroidapp.domain.appdetails.AppDetails
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi,
): AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val dto = api.getAppDetails(id)
        val domain = mapper.map(dto)
        return domain
    }
}