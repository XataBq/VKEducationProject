package com.example.firstandroidapp.data.mapper

import com.example.firstandroidapp.data.remote.dto.AppShortDetailsDto
import com.example.firstandroidapp.domain.applist.AppShortDetails
import javax.inject.Inject

class AppShortDetailsMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {
    fun map(dto: AppShortDetailsDto): AppShortDetails {
        return AppShortDetails(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            category = categoryMapper.map(dto.category),
            iconUri = dto.iconUrl
        )
    }
}