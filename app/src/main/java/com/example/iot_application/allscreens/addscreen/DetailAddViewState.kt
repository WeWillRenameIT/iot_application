package com.example.iot_application.allscreens.addscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.userdetailscreen.DetailUserViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun DetailAddViewState(
    token: String,
    userOrNot: Boolean,
    navController: NavHostController,
    showDialog: Boolean,
    fnShowDialog: (Boolean) -> Unit,
    viewModel: DetailAddModel = hiltViewModel()
) {

    var login by remember { mutableStateOf("") }
    var first_name by remember { mutableStateOf("") }
    var last_name by remember { mutableStateOf("") }
    var patronym by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("0") }
    var name by remember { mutableStateOf("") }
    var describe by remember { mutableStateOf("") }
    var heightScreen by remember { mutableStateOf(550) }

    if(!userOrNot)
        heightScreen = 250

    if (showDialog) {
        Dialog(onDismissRequest = {}) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(400.dp)
                    .height( heightScreen.dp)
                    .background(Color.White)
                    .padding(bottom = 7.dp)
            ) {
                if(userOrNot) {
                    AddUserView(
                        login = login,
                        fn_login = { login = it },
                        first_name = first_name,
                        fn_first_name = { first_name = it },
                        last_name = last_name,
                        fn_last_name = { last_name = it },
                        patronym = patronym,
                        fn_patronym = { patronym = it },
                        password = password,
                        fn_password = { password = it },
                        code = code,
                        fn_code = { code = it },
                        role = role,
                        fn_role = { role = it },
                        fn_button = {
                            runBlocking {
                                viewModel.postAddUser(
                                    token,
                                    login,
                                    first_name,
                                    last_name,
                                    patronym,
                                    password,
                                    code,
                                    role.toInt(),
                                )
                                fnShowDialog(false)
                                navController.navigate(Screens.UsersScreen.withArgs(token))
                            }

                        },
                        fn_button_cancel = { runBlocking { fnShowDialog(false) } }
                    )
                }
                else {
                    AddCodeLockView(
                        name = name,
                        fn_name = {name = it},
                        describe = describe,
                        fn_describe = { describe = it },
                        fn_button = {
                            runBlocking {
                                viewModel.postAddCodeLock(
                                    token = token,
                                    name = name,
                                    describe = describe
                                )
                                fnShowDialog(false)
                                navController.navigate(Screens.CodeLocksScreen.withArgs(token))
                            }

                        },
                        fn_button_cancel = { runBlocking { fnShowDialog(false) } }
                    )
                }
            }

        }
    }

    
}