package com.example.firstandroidapp.domain.appdetails

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    fun observeAppDetails(id: String): Flow<AppDetails>
    suspend fun refreshAppDetails(id:String)

    suspend fun toggleWishlist(id: String)
}