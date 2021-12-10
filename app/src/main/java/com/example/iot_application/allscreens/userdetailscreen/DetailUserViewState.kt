package com.example.iot_application.allscreens.userdetailscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.authorisescreen.AuthoriseViewModel
import com.example.iot_application.allscreens.navigation.saveToken
import com.example.iot_application.data.remote.responses.IotUsersItem
import kotlinx.coroutines.runBlocking

@Composable
fun DetailUserViewState(
    token: String,
    user: IotUsersItem,
    fntest: () -> Unit,
    viewModel: DetailUserViewModel = hiltViewModel()

) {


    var login by remember { mutableStateOf("") }
    var first_name by remember { mutableStateOf("") }
    var last_name by remember { mutableStateOf("") }
    var patronym by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("${user.Role}") }


    Column() {



        DetailUserView(
            iotUsersItem = user,
            login = login,
            first_name = first_name,
            last_name = last_name,
            patronym = patronym,
            password = password,
            code = code,
            role = role,
            fn_login = { login = it },
            fn_first_name = { first_name = it },
            fn_last_name = { last_name = it },
            fn_patronym = { patronym = it },
            fn_password = { password = it },
            fn_code = { code = it },
            fn_role = { role = it },
            fn_button_delete = {
                runBlocking {

                    var result = viewModel.postDeleteUser(
                        token = token,
                        user_id = user.Id.toString())

                    if(result.data=="user deleted")
                    {
                        fntest.invoke()
                    }

                }
            },
            fn_button_save = {
                runBlocking {

                    var result = viewModel.postEditUser(
                        token = token,
                        user_id = user.Id.toString(),
                        login = login,
                        first_name = first_name,
                        last_name = last_name,
                        patronym = patronym,
                        password = password,
                        code = code,
                        role = role)
                    if(result.data=="user edited")
                    {
                        fntest.invoke()
                    }

                }
            }

        )
    }
    //Text(text = "Детальный экран Пользователя")
    
}