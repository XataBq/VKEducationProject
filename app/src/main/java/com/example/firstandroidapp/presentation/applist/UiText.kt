package com.example.firstandroidapp.presentation.applist

import android.content.Context

sealed interface UiText {
    data class DynamicString(val value: String) : UiText
    data class StringResource(val resId: Int) : UiText
}

fun UiText.asString(context: Context): String {
    return when (this) {
        is UiText.DynamicString -> value
        is UiText.StringResource -> context.getString(resId)
    }
}