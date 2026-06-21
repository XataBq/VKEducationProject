package com.example.firstandroidapp.data.local.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.firstandroidapp.data.local.CategoryConverter
import com.example.firstandroidapp.data.local.StringListConverter
import com.example.firstandroidapp.data.local.dao.AppDetailsDao
import com.example.firstandroidapp.data.local.entity.AppDetailsEntity

@Database(
    entities = [AppDetailsEntity::class],
    version = 1,
)
@TypeConverters(
    CategoryConverter::class,
    StringListConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDetailsDao(): AppDetailsDao

    companion object {
        const val DATABASE_NAME = "app_database"
    }

}