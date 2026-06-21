package com.example.firstandroidapp.data.local

import androidx.room.TypeConverter

class StringListConverter {

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.joinToString(separator = "|||")
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return value
            ?.takeIf { it.isNotBlank() }
            ?.split("|||")
    }
}