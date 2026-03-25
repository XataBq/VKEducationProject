package com.example.firstandroidapp.presentation.extensions

import com.example.firstandroidapp.R
import com.example.firstandroidapp.domain.util.AppError
import com.example.firstandroidapp.presentation.applist.UiText

fun AppError.toUiText(): UiText {
    return when (this) {
        AppError.Network -> UiText.StringResource(R.string.error_network)
        AppError.Unauthorized -> UiText.StringResource(R.string.error_unauthorized)
        AppError.NotFound -> UiText.StringResource(R.string.error_not_found)
        AppError.Server -> UiText.StringResource(R.string.error_server)
        is AppError.Unknown -> {
            if (message.isNullOrBlank()) {
                UiText.StringResource(R.string.error_unknown)
            } else {
                UiText.DynamicString(message)
            }
        }
    }
}