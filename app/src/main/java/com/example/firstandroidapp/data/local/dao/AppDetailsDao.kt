package com.example.firstandroidapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firstandroidapp.data.local.entity.AppDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDetailsDao {
    @Query("SELECT * FROM app_details WHERE id = :id")
    fun getAppDetails(id: String): Flow<AppDetailsEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAppDetails(appDetails: AppDetailsEntity)

    @Query("UPDATE app_details SET isInWishlist = :isInWishlist WHERE id = :id")
    suspend fun updateWishListStatus(id: String, isInWishlist: Boolean)

//    @Query("DELETE FROM app_details WHERE id = :id")
//    suspend fun deleteAppDetails(id: String)
}