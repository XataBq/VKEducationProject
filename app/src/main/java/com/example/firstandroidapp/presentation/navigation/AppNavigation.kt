package com.example.firstandroidapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstandroidapp.presentation.appdetails.AppDetailsScreen
import com.example.firstandroidapp.presentation.applist.AppListScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ListOfApps.route,
        modifier = modifier
    ) {
        composable(Screen.ListOfApps.route) {
            AppListScreen(
                onAppClick = {
                    navController.navigate(Screen.AppDetails.route){
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            Screen.AppDetails.route,
//            Now don't need, but later may be useful
//            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            //Detailed app screen is everywhere the same yet
            AppDetailsScreen(
                modifier = Modifier.fillMaxSize().safeDrawingPadding(),
                onBackClick = {
                    //Чтобы не было blank screen
                    if (!navController.popBackStack()){
                        navController.navigate(Screen.ListOfApps.route) {
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}