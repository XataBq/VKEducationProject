package com.example.firstandroidapp.domain.util

sealed interface AppError {
    data object Network: AppError
    data object Server: AppError
    data object Unauthorized: AppError
    data object NotFound: AppError
    data class Unknown(val message: String? = null): AppError
}