package com.example.firstandroidapp.domain.appdetails

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails
}