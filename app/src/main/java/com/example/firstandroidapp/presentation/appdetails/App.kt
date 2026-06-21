package com.example.firstandroidapp.presentation.appdetails

import com.example.firstandroidapp.domain.appdetails.Category


data class App(
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
)