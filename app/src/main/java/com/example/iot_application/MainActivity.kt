package com.example.iot_application

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.iot_application.allscreens.journalscreen.PlusUserView
import com.example.iot_application.allscreens.navigation.NavigationScreenState
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()
            var prefs : SharedPreferences = getSharedPreferences("token", Context.MODE_PRIVATE)
            //PlusUserView()
            NavigationScreenState(prefs = prefs, navController = navController)
            //JournalScreenState()
            //UsersScreenState()
        }
    }
}

