package com.example.firstandroidapp.data.repository

import com.example.firstandroidapp.core.dispatchers.IoDispatcher
import com.example.firstandroidapp.data.local.dao.AppDetailsDao
import com.example.firstandroidapp.data.mapper.AppDetailsEntityMapper
import com.example.firstandroidapp.data.mapper.AppDetailsMapper
import com.example.firstandroidapp.data.remote.api.AppDetailsApi
import com.example.firstandroidapp.domain.appdetails.AppDetails
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val dtoMapper: AppDetailsMapper,
    private val api: AppDetailsApi,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): AppDetailsRepository {

    override fun observeAppDetails(id: String): Flow<AppDetails> {
        return dao.getAppDetails(id).map { entity ->
            if (entity != null) {
                entityMapper.toDomain(entity)
            } else {
                val dto = api.getAppDetails(id)
                val domain = dtoMapper.map(dto)
                val newEntity = entityMapper.toEntity(domain)
                withContext(ioDispatcher) {
                    dao.insertAppDetails(newEntity)
                }
                domain
            }
        }
    }

    override suspend fun refreshAppDetails(id: String) {
        val dto = api.getAppDetails(id)
        val domain = dtoMapper.map(dto)
        val entity = entityMapper.toEntity(domain)
        withContext(ioDispatcher) {
            dao.insertAppDetails(entity)
        }
    }
}