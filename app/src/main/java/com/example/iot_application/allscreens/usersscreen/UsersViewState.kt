package com.example.iot_application.allscreens.usersscreen

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.journalscreen.PlusUserView
import kotlinx.coroutines.runBlocking


@Composable
fun UsersScreenState(
    iotToken: String,
    navController: NavHostController,
    viewModel: UsersViewModel = hiltViewModel(),


    ) {
    val usersList by remember { viewModel.usersList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }


    Log.e("JSS -> ", usersList.toString())
    var loadList by remember { mutableStateOf(true) }
    if (loadList) {
        runBlocking {
            viewModel.getUsers(iotToken)
        }
        loadList = false
    }

    LazyColumn(
        contentPadding = PaddingValues(10.dp)
    ) {
        items(usersList.size) {
            UserScreenRow(
                id = it + 1,
                role = usersList[it].Role,
                username = usersList[it].Fio,
                fnButton = {
                    navController.navigate(Screens.DetailUserScreen.withArgs(iotToken))
                }
            )
        }
        items(1)
        {
            Spacer(modifier = Modifier.height(60.dp))
        }

    }

    // TODO: 13.11.2021 Добавление пользователя
    PlusUserView({ })


    Log.e("JSS -> ", usersList.toString())

}