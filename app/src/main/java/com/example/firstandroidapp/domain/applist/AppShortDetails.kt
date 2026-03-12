package com.example.firstandroidapp.domain.applist

import com.example.firstandroidapp.domain.appdetails.Category

data class AppShortDetails(
    val id: String,
    val name: String,
    val category: Category,
    val iconUri: String,
    val description: String,
)