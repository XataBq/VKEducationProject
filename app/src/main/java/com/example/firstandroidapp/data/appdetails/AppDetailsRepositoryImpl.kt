package com.example.firstandroidapp.data.appdetails

import com.example.firstandroidapp.domain.appdetails.AppDetails
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository

class AppDetailsRepositoryImpl: AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        TODO("Здесь будет реализован бэкэнд")
    }
}