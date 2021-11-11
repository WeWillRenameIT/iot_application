package com.example.iot_application.allscreens.authorisescreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.iot_application.allscreens.Screens
import kotlinx.coroutines.runBlocking

@Composable
fun AuthoriseScreenState(
    navController: NavController,
    viewModel: AuthoriseViewModel = hiltViewModel()

) {

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var iotToken by remember { mutableStateOf("") }



    AuthoriseScreen(
        login = login,
        password = password,
        iotToken = iotToken,
        passwordVisibility = passwordVisibility,
        fnLogin = {login = it},
        fnPassword = {password = it},
        fnPasswordVisibility = {passwordVisibility = !passwordVisibility},
        fnButton = {
                        runBlocking {
                            iotToken = if (viewModel.postAuthorise(login,password).data != null) viewModel.postAuthorise(login,password).data!!.Token else ""

                        }
                        if (iotToken != "") navController.navigate(Screens.JournalScreen.withArgs(iotToken))
                   },
    )
    Log.e("ASS -> ", "login: $login password: $password token: $iotToken" )

}