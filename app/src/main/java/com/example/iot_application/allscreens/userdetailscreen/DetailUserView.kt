package com.example.iot_application.allscreens.userdetailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.iot_application.data.remote.responses.IotUsersItem
import com.example.iot_application.util.Resource

@Composable
fun DetailUserView(

    iotUsersItem: IotUsersItem,

    login: String,
    fn_login: (String)->Unit,

    first_name: String,
    fn_first_name: (String)->Unit,

    last_name: String,
    fn_last_name: (String)->Unit,

    patronym: String,
    fn_patronym: (String)->Unit,

    password: String,
    fn_password: (String)->Unit,

    code: String,
    fn_code: (String)->Unit,

    role: String,
    fn_role: (String)->Unit,

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
            value = login,
            label = { Text("Логин") },
            onValueChange = fn_login,
            placeholder = { Text(iotUsersItem.Username) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))

        TextField(
            value = first_name,
            onValueChange = fn_first_name,
            label = { Text("Имя") },
            placeholder = { Text(iotUsersItem.First_name) },
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
            value = last_name,
            onValueChange = fn_last_name,
            label = { Text("Фамилия") },
            placeholder = { Text(iotUsersItem.Last_name) },
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
            value = patronym,
            onValueChange = fn_patronym,
            label = { Text("Отчество") },
            placeholder = { Text(iotUsersItem.Patronym) },
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
            value = password,
            onValueChange = fn_password,
            label = { Text("Пароль") },
            placeholder = { Text("") },
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
            value = code,
            onValueChange = fn_code,
            placeholder = { Text("") },
            label = { Text("Код") },
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



        var expanded by remember { mutableStateOf(false) }
        val suggestions = listOf("0","1","2")
        var selectedText by remember { mutableStateOf(role) }

        var textfieldSize by remember { mutableStateOf(Size.Zero)}

        val icon = if (expanded)
            Icons.Filled.ArrowDropUp //it requires androidx.compose.material:material-icons-extended
        else
            Icons.Filled.ArrowDropDown

        Column() {
            OutlinedTextField(
                readOnly = true,
                value = if(selectedText=="0") "Работник" else if(selectedText=="1") "Модератор" else "Администратор" ,
                onValueChange = { fn_role },

                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                label = {Text("Роль")},
                trailingIcon = {
                    Icon(icon,"",
                        Modifier.clickable { expanded = !expanded })
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current){textfieldSize.width.toDp()})
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        fn_role.invoke(label)
                        selectedText = label
                        expanded = !expanded
                    }) {
                        Text(text = if(label=="0") "Работник" else if(label=="1") "Модератор" else "Администратор")
                    }
                }
            }
        }









//        TextField(
//            value = role,
//            onValueChange = fn_role,
//            label = { Text("Роль") },
//            placeholder = { Text(iotUsersItem.Role.toString()) },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Color(0xFF0D47A1),
//                backgroundColor = Color(0xFFC3DAFF),
//                focusedLabelColor = Color(0xFF0D47A1),
//
//                ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(55.dp)
//
//        )

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