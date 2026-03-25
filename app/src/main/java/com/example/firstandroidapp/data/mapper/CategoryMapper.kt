package com.example.firstandroidapp.data.mapper

import com.example.firstandroidapp.domain.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun map(category: String): Category =
        Category.fromString(category)
}