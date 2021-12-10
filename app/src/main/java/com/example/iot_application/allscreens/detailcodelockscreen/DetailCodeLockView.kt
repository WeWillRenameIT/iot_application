package com.example.iot_application.allscreens.detailcodelockscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iot_application.data.remote.responses.IotCodeLockItem
import com.example.iot_application.data.remote.responses.IotUsersItem

@Composable
fun DetailCodeLockView(

    iotCodeLockItem: IotCodeLockItem,

    name: String,
    fn_name: (String)->Unit,

    describe: String,
    fn_describe: (String)->Unit,


    fn_button_delete: () -> Unit,
    fn_button_save: () -> Unit

) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp),
    ) {


        TextField(
            value = name,
            label = { Text("Имя") },
            onValueChange = fn_name,
            placeholder = { Text(iotCodeLockItem.Name) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))

        TextField(
            value = describe,
            onValueChange = fn_describe,
            label = { Text("Описание") },
            placeholder = { Text(iotCodeLockItem.Description) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = fn_button_delete,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFD8353C),
                    contentColor = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .height(40.dp)
                    .width(150.dp)
            ) {
                Text(text = "Удалить", fontSize = 16.sp)
            }
            Button(
                onClick = fn_button_save,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF51A84B),
                    contentColor = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .height(40.dp)
                    .width(150.dp)
            ) {
                Text(text = "Сохранить", fontSize = 16.sp)
            }
        }

    }
}