package com.example.firstandroidapp.presentation.navigation

sealed class Screen(
    val route: String
) {
    data object ListOfApps: Screen("list_of_apps")
    data object AppDetails: Screen("app_details/{appId}") {
        const val APP_ID = "appId"

        fun createRoute(appId: String): String {
            return "app_details/$appId"
        }
    }
}