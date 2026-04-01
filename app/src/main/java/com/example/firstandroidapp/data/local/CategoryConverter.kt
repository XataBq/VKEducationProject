package com.example.firstandroidapp.data.local

import androidx.room.TypeConverter
import com.example.firstandroidapp.domain.Category


class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.title

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.fromString(categoryName)
}