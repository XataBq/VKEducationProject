package com.example.firstandroidapp.data.di

import com.example.firstandroidapp.data.repository.AppDetailsRepositoryImpl
import com.example.firstandroidapp.data.repository.AppListRepositoryImpl
import com.example.firstandroidapp.domain.appdetails.AppDetailsRepository
import com.example.firstandroidapp.domain.applist.AppListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppListRepository(
        impl: AppListRepositoryImpl
    ): AppListRepository

    @Binds
    @Singleton
    abstract fun bindAppDetailsRepository(
        impl: AppDetailsRepositoryImpl
    ): AppDetailsRepository
}