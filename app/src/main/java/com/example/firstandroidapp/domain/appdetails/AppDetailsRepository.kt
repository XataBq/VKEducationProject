package com.example.firstandroidapp.domain.appdetails

interface AppDetailsRepository {
    fun get(id: String): AppDetails
}