package com.example.firstandroidapp.data.applist

import com.example.firstandroidapp.data.mapper.CategoryMapper
import com.example.firstandroidapp.domain.applist.AppShortDetails
import javax.inject.Inject

class AppShortDetailsMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {
    fun map(dto: AppShortDetailsDto): AppShortDetails {
        return AppShortDetails(
            id = dto.id,
            name = dto.name,
            category = categoryMapper.map(dto.category),
            iconUri = dto.iconUri,
            description = dto.description
        )
    }
}