package com.example.firstandroidapp.presentation.navigation

import android.net.Uri

sealed class Screen(
    val route: String
) {
    data object ListOfApps: Screen("list_of_apps")
    data object AppDetails: Screen("app_details")
}