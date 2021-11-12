package com.example.iot_application.allscreens.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.authorisescreen.AuthoriseScreenState
import com.example.iot_application.allscreens.codelocksscreen.CodeLocksScreenState
import com.example.iot_application.allscreens.journalscreen.JournalScreenState
import com.example.iot_application.allscreens.usersscreen.UsersScreenState

@Composable
fun NavigationScreenState() {

    val navController = rememberNavController()
    var selectedScreen by remember { mutableStateOf(2) }
    var iotToken by remember { mutableStateOf("test") }

    Scaffold(
        bottomBar = {
            if(iotToken!= "test")
            NavigationBar(
                fnPeople = {
                    selectedScreen = 1
                    navController.navigate(Screens.UsersScreen.withArgs(iotToken))
                },
                fnList = {
                    selectedScreen = 2
                    navController.navigate(Screens.JournalScreen.withArgs(iotToken))
                },
                fnLock = {
                    selectedScreen = 3
                    navController.navigate(Screens.CodeLocksScreen.withArgs(iotToken))
                },
                fnInfo = {
                    selectedScreen = 4
                    navController.navigate(Screens.InfoScreen.withArgs(iotToken))
                },
                selectedScreen = selectedScreen
            )
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = Screens.AuthoriseScreen.route
        )
        {
            composable(
                route = Screens.AuthoriseScreen.route
            ) {
                AuthoriseScreenState(navController = navController)
            }

            composable(
                route = Screens.UsersScreen.route + "/{iotToken}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                UsersScreenState(iotToken)

            }
            composable(
                route = Screens.JournalScreen.route + "/{iotToken}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                JournalScreenState(iotToken)

            }
            composable(
                route = Screens.CodeLocksScreen.route + "/{iotToken}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                CodeLocksScreenState(iotToken)
            }

            composable(
                route = Screens.InfoScreen.route + "/{iotToken}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                Text("Проект для IOT\nГруппа: ИВБО-05-18\nПередерий Владимир\nИваннов Дмитрий\nМурашев Александр\nКапырин Константин\nЧернышев Владислав")
            }
        }
    }
}