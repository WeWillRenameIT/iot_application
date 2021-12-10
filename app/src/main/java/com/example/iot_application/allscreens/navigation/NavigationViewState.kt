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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.iot_application.allscreens.InfoScreen
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.addscreen.DetailAddViewState
import com.example.iot_application.allscreens.authorisescreen.AuthoriseScreenState
import com.example.iot_application.allscreens.codelocksscreen.CodeLocksScreenState
import com.example.iot_application.allscreens.detailcodelockscreen.DetailCodeLockViewState
import com.example.iot_application.allscreens.infoscreen.InfoViewState
import com.example.iot_application.allscreens.journalscreen.JournalScreenState
import com.example.iot_application.allscreens.userdetailscreen.DetailUserViewState
import com.example.iot_application.allscreens.usersscreen.UsersScreenState
import com.example.iot_application.data.remote.responses.IotCodeLockItem
import com.example.iot_application.data.remote.responses.IotUsersItem
import com.example.iot_application.util.Resource
import kotlinx.coroutines.runBlocking

@Composable
fun NavigationScreenState(
    prefs: SharedPreferences,
    navController: NavHostController,
    viewModel: NavigationModel = hiltViewModel()
) {

    var selectedScreen by remember { mutableStateOf(2) }
    var iotToken by remember { mutableStateOf("") }
    var flagAuth by remember { mutableStateOf(false) }
    val (showAddDialog, setShowAddDialog) = remember { mutableStateOf(false) }

    //saveToken("", prefs)
    iotToken = getToken(prefs)


    if(iotToken!="") {
        runBlocking {
            var verify = viewModel.postTokenVerify(iotToken)
            if(verify.data != "200"){
                flagAuth = true
            }
        }

    }
    if(flagAuth) {
        flagAuth = false
        saveToken("", prefs)
    }

    Log.e("NVS-3 -> ", "$iotToken")

    Scaffold(
        bottomBar = {
            if(iotToken!= "")
            NavigationBar(
                fnPeople = {
                    setShowAddDialog(false)
                    selectedScreen = 1
                    navController.navigate(Screens.UsersScreen.withArgs(iotToken))
                },
                fnList = {
                    selectedScreen = 2
                    navController.navigate(Screens.JournalScreen.withArgs(iotToken))
                },
                fnLock = {
                    setShowAddDialog(false)
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
                UsersScreenState(
                    iotToken = iotToken,
                    showAddDialog = showAddDialog,
                    setShowAddDialog = setShowAddDialog,
                    navController = navController,
                    fnButton = {
                        navController.navigate(Screens.DetailUserScreen.withArgs(iotToken))

                    })
                DetailAddViewState(showDialog = showAddDialog, fnShowDialog = setShowAddDialog, token = iotToken, userOrNot = true, navController = navController)
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
                CodeLocksScreenState(iotToken = iotToken, setShowAddDialog = setShowAddDialog, navController = navController)
                DetailAddViewState(showDialog = showAddDialog, fnShowDialog = setShowAddDialog, token = iotToken, userOrNot = false, navController = navController)
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
                route = Screens.DetailUserScreen.route + "/{iotToken}/{First_name}/{Last_name}/{Patronym}/{Username}/{Id}/{Role}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    },
                    navArgument("First_name") {
                        type = NavType.StringType
                    },
                    navArgument("Last_name") {
                        type = NavType.StringType
                    },
                    navArgument("Patronym") {
                        type = NavType.StringType
                    },
                    navArgument("Username") {
                        type = NavType.StringType
                    },
                    navArgument("Id") {
                        type = NavType.StringType
                    },
                    navArgument("Role") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                var user = IotUsersItem(
                    First_name = entry.arguments?.getString("First_name")!!,
                    Last_name = entry.arguments?.getString("Last_name")!!,
                    Patronym = entry.arguments?.getString("Patronym")!!,
                    Username = entry.arguments?.getString("Username")!!,
                    Id = entry.arguments?.getString("Id")!!.toInt(),
                    Role = entry.arguments?.getString("Role")!!.toInt()
                )
                DetailUserViewState(iotToken,user, fntest = {navController.navigate(Screens.UsersScreen.withArgs(iotToken))})
            }

            composable(
                route = Screens.DetailCodeLockScreen.route + "/{iotToken}/{codelock_id}/{describe}/{name}",
                arguments = listOf(
                    navArgument("iotToken") {
                        type = NavType.StringType
                    },
                    navArgument("codelock_id") {
                        type = NavType.StringType
                    },
                    navArgument("describe") {
                        type = NavType.StringType
                    },
                    navArgument("name") {
                        type = NavType.StringType
                    }
                )
            ) {
                    entry ->
                iotToken = entry.arguments?.getString("iotToken")!!
                var codeLock = IotCodeLockItem(
                    Id = entry.arguments?.getString("codelock_id")!!.toInt(),
                    Description = entry.arguments?.getString("describe")!!,
                    Name = entry.arguments?.getString("name")!!,
                )
                DetailCodeLockViewState(codeLock = codeLock, token = iotToken,fntest = {navController.navigate(Screens.CodeLocksScreen.withArgs(iotToken))} )
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