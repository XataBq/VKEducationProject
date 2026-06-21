package com.example.firstandroidapp.data.appdetails

import com.example.firstandroidapp.domain.appdetails.AppDetails
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository

class AppDetailsMockRepositoryImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi,
): AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val dto = api.get(id)
        val domain = mapper.map(dto)
        return domain
    }
}