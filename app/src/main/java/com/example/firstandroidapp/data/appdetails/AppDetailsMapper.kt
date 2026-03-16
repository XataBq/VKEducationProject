package com.example.firstandroidapp.data.appdetails

import com.example.firstandroidapp.data.mapper.CategoryMapper
import com.example.firstandroidapp.domain.appdetails.AppDetails

class AppDetailsMapper(
    private val categoryMapper: CategoryMapper
){
    fun map(dto: AppDetailsDto): AppDetails {
        return AppDetails(
            id = dto.id,
            name = dto.name,
            developer = dto.developer,
            category = categoryMapper.map(dto.category),
            ageRating = dto.ageRating,
            size = dto.size,
            iconUrl = dto.iconUrl,
            screenshotUrlList = dto.screenshotUrlList,
            description = dto.description
        )
    }
}