package com.example.firstandroidapp.domain.appdetails

import com.example.firstandroidapp.domain.Category

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>?,
    val description: String,
    val isInWishlist: Boolean,
)