package com.example.iot_application.allscreens.navigation

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.iot_application.allscreens.InfoScreen
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.authorisescreen.AuthoriseScreenState
import com.example.iot_application.allscreens.codelocksscreen.CodeLocksScreenState
import com.example.iot_application.allscreens.detailcodelockscreen.DetailUserViewState
import com.example.iot_application.allscreens.infoscreen.InfoViewState
import com.example.iot_application.allscreens.journalscreen.JournalScreenState
import com.example.iot_application.allscreens.usersscreen.UsersScreenState

@Composable
fun NavigationScreenState(
    prefs: SharedPreferences,
    navController: NavHostController
) {

    var selectedScreen by remember { mutableStateOf(2) }
    var iotToken by remember { mutableStateOf("") }

    //saveToken("", prefs)
    iotToken = getToken(prefs)

    Log.e("NSS-3 -> ", "$iotToken")

    Scaffold(
        bottomBar = {
            if(iotToken!= "")
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

                Log.e("NSS -> 1: ", "save token: $iotToken")
                if(getToken(prefs)=="") {
                    iotToken=""
                    selectedScreen = 2
                    AuthoriseScreenState(navController = navController, prefs = prefs)
                }
                else {
                    JournalScreenState(iotToken)
                }

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
                //UsersScreenState(iotToken = iotToken,navController = navController)

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
                //CodeLocksScreenState(iotToken = iotToken, navController = navController)
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
                InfoViewState( navController = navController, prefs = prefs)
            }

            composable(
                route = Screens.DetailUserScreen.route + "/{iotToken}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                DetailUserViewState()
            }

            composable(
                route = Screens.DetailUserScreen.route + "/{iotToken}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                DetailUserViewState()
            }

        }
    }
}



fun saveToken(token: String, prefs: SharedPreferences)
{
    val editor = prefs.edit()
    editor.putString ("token", token).apply()
}


fun getToken(prefs: SharedPreferences) : String
{
    return prefs.getString("token", "")!!
}