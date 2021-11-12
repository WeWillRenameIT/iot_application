package com.example.iot_application.allscreens.infoscreen

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.iot_application.allscreens.InfoScreen
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.navigation.saveToken

@Composable
fun InfoViewState(
    navController: NavHostController,
    prefs: SharedPreferences
) {
    InfoScreen(
        fnButton = {
            saveToken("", prefs)
            navController.navigate(Screens.AuthoriseScreen.route)
        }

    )
}