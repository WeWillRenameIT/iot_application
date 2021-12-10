package com.example.iot_application.allscreens.detailcodelockscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.iot_application.allscreens.addscreen.AddCodeLockView
import com.example.iot_application.allscreens.addscreen.AddUserView
import com.example.iot_application.allscreens.addscreen.DetailAddModel
import com.example.iot_application.allscreens.userdetailscreen.DetailUserView
import com.example.iot_application.data.remote.responses.IotCodeLockItem
import kotlinx.coroutines.runBlocking

@Composable


fun DetailCodeLockViewState(
token: String,
codeLock: IotCodeLockItem,
fntest: () -> Unit,
viewModel: DetailCodeLockModel = hiltViewModel()

) {


    var name by remember { mutableStateOf("") }
    var describe by remember { mutableStateOf("") }



    Column() {


        DetailCodeLockView(
            iotCodeLockItem = codeLock,
            name = name,
            describe = describe,
            fn_name = { name = it },
            fn_describe = { describe = it },
            fn_button_delete = {
                runBlocking {

                    var result = viewModel.postDeleteCodeLock(
                        token = token,
                        codelock_id = codeLock.Id.toString()
                    )

                    if (result.data == "codelock deleted") {
                        fntest.invoke()
                    }

                }
            },
            fn_button_save = {
                runBlocking {

                    var result = viewModel.postEditCodeLock(
                        token = token,
                        codelock_id = codeLock.Id.toString(),
                        describe = describe,
                        name = name
                    )
                    if (result.data == "codelock edited") {
                        fntest.invoke()
                    }

                }
            }

        )
    }
    //Text(text = "Детальный экран Пользователя")

}