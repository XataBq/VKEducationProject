package com.example.firstandroidapp.data.appdetails

import com.example.firstandroidapp.domain.appdetails.AppDetails
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsMockRepositoryImpl @Inject constructor(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi,
): AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val dto = api.get(id)
        val domain = mapper.map(dto)
        return domain
    }
}