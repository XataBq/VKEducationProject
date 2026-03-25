package com.example.firstandroidapp.domain.util

sealed interface DataResult<out T> {
    data class Success<out T>(val data: T): DataResult<T>
    data class Error(val error: AppError): DataResult<Nothing>
}