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
import kotlinx.coroutines.runBlocking


@Composable
fun UsersScreenState(
    iotToken: String,
    viewModel: UsersViewModel = hiltViewModel()

    ) {
        val usersList by remember { viewModel.usersList }
        val endReached by remember { viewModel.endReached }
        val loadError by remember { viewModel.loadError }
        val isLoading by remember { viewModel.isLoading }


        Log.e("JSS -> ", usersList.toString())
        var loadList by remember { mutableStateOf(true) }
        if(loadList) {
            runBlocking {
                viewModel.getUsers(iotToken)
            }
            loadList = false
        }

        LazyColumn(
            contentPadding = PaddingValues(10.dp)
        ){
            items(usersList.size){
                UserScreenRow(
                    id = it+1,
                    role = usersList[it].Role,
                    username = usersList[it].Fio
                )
            }
            items(1)
            {
                Spacer(modifier = Modifier.height(60.dp))
            }

        }


        Log.e("JSS -> ", usersList.toString())

    }