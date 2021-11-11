package com.example.iot_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent

import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.authorisescreen.AuthoriseScreen
import com.example.iot_application.allscreens.authorisescreen.AuthoriseScreenState
import com.example.iot_application.allscreens.journalscreen.JournalScreenState
import com.example.iot_application.allscreens.navigation.NavigationBar
import com.example.iot_application.allscreens.navigation.NavigationScreenState
import com.example.iot_application.allscreens.usersscreen.UsersScreenState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: 11.11.2021 (тестовая навигация/проверка работы собранного приложения) СНЕСТИ НАХЕР ЭТОТ БЕСПРЕДЕЛ. РАЗБИТЬ НА ЭЛЕМЕНТЫ. ВЫНЕСТИ ИЗ MainActivity нахуй

        setContent {
            NavigationScreenState()
            //JournalScreenState()
            //UsersScreenState()
        }
    }
}

