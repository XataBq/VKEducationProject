package com.example.firstandroidapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.firstandroidapp.domain.Category

@Entity(tableName = "app_details")
data class AppDetailsEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshots: List<String>?,
    val description: String,
    val lastUpdated: Long = System.currentTimeMillis(),
    val isInWishlist: Boolean,
)