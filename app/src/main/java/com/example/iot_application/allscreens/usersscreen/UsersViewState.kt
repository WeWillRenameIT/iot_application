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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.journalscreen.PlusUserView
import kotlinx.coroutines.runBlocking


@Composable
fun UsersScreenState(
    iotToken: String,
    navController: NavController,
    showAddDialog: Boolean,
    setShowAddDialog: (Boolean)->Unit,
    fnButton: ()->Unit,
    viewModel: UsersViewModel = hiltViewModel(),


    ) {
    val usersList by remember { viewModel.usersList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }
    var token500  by remember { mutableStateOf(false) }

    Log.e("JSS -> ", usersList.toString())
    var loadList by remember { mutableStateOf(true) }
    if (loadList) {
        runBlocking {
            var result = viewModel.getUsers(iotToken)
            if(result!="200"){
                token500 = true;
                //TODO Сделать выход
            }
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
                username = "${usersList[it].Last_name} ${usersList[it].First_name} ${usersList[it].Patronym}"  ,
                fnButton = {
                    navController.navigate(Screens.DetailUserScreen.withArgs(
                        iotToken,
                        usersList[it].First_name,
                        if(usersList[it].Last_name!="") usersList[it].Last_name else "Нет" ,
                        if(usersList[it].Patronym!="") usersList[it].Patronym else "Нет" ,
                        usersList[it].Username,
                        usersList[it].Id.toString(),
                        usersList[it].Role.toString()
                        ))
                }
            )
        }
        items(1)
        {
            Spacer(modifier = Modifier.height(60.dp))
        }

    }


    PlusUserView(fnButton = {
        setShowAddDialog(true)
    })


    Log.e("JSS -> ", usersList.toString())

}