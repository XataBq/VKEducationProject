package com.example.firstandroidapp.data.mapper


import com.example.firstandroidapp.data.local.entity.AppDetailsEntity
import com.example.firstandroidapp.domain.appdetails.AppDetails
import javax.inject.Inject

class AppDetailsEntityMapper @Inject constructor() {

    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category,
        ageRating = domain.ageRating,
        size = domain.size,
        iconUrl = domain.iconUrl,
        screenshots = domain.screenshotUrlList,
        description = domain.description,
        isInWishlist = false
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = entity.category,
        ageRating = entity.ageRating,
        size = entity.size,
        iconUrl = entity.iconUrl,
        screenshotUrlList = entity.screenshots,
        description = entity.description,
        isInWishlist = entity.isInWishlist
    )
}