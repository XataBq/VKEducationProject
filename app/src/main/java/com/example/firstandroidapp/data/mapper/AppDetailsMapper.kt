package com.example.firstandroidapp.data.mapper

import com.example.firstandroidapp.data.remote.dto.AppDetailsDto
import com.example.firstandroidapp.domain.appdetails.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor(
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
            description = dto.description,
            isInWishlist = false
        )
    }
}