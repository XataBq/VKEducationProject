package com.example.firstandroidapp.domain.applist

import com.example.firstandroidapp.domain.Category

data class AppShortDetails(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
    val iconUri: String,
)