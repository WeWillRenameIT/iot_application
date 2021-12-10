package com.example.iot_application.allscreens.addscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
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

@Composable
fun AddUserView(
    login: String,
    fn_login: (String) -> Unit,
    first_name: String,
    fn_first_name: (String) -> Unit,
    last_name: String,
    fn_last_name: (String) -> Unit,
    patronym: String,
    fn_patronym: (String) -> Unit,
    password: String,
    fn_password: (String) -> Unit,
    code: String,
    fn_code: (String) -> Unit,
    role: String,
    fn_role: (String) -> Unit,
    fn_button: () -> Unit,
    fn_button_cancel: () -> Unit,

    ) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
    ) {

        Text(text = "Заполните поля",fontSize = 18.sp)
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = login,
            onValueChange = fn_login,
            placeholder = { Text("Логин") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = first_name,
            onValueChange = fn_first_name,
            placeholder = { Text("Имя") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = last_name,
            onValueChange = fn_last_name,
            placeholder = { Text("Фамилия") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = patronym,
            onValueChange = fn_patronym,
            placeholder = { Text("Отчество") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),
                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = password,
            onValueChange = fn_password,
            placeholder = { Text("Пароль") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )

        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = code,
            onValueChange = fn_code,
            placeholder = { Text("Код") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))








        var expanded by remember { mutableStateOf(false) }
        val suggestions = listOf("0","1","2")
        var selectedText by remember { mutableStateOf(role) }

        var textfieldSize by remember { mutableStateOf(Size.Zero) }

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
//            placeholder = { Text("role") },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Color(0xFF0D47A1),
//                backgroundColor = Color(0xFFC3DAFF),
//                focusedLabelColor = Color(0xFF0D47A1),
//
//                ),
//            modifier = Modifier
//                .width(IntrinsicSize.Max)
//                .height(50.dp)
//
//        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = fn_button_cancel,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF0D47A1),
                    contentColor = Color(0xFFC3DAFF),
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp)
            ) {
                Text(text = "Отмена")
            }

            Button(
                onClick = fn_button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF0D47A1),
                    contentColor = Color(0xFFC3DAFF),
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp)
            ) {
                Text(text = "Добавить")
            }

        }

    }
}


@Composable
fun AddCodeLockView(
    name: String,
    fn_name: (String) -> Unit,
    describe: String,
    fn_describe: (String) -> Unit,
    fn_button: () -> Unit,
    fn_button_cancel: () -> Unit,

    ) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
    ) {

        Text(text = "Заполните поля",fontSize = 16.sp)
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = name,
            onValueChange = fn_name,
            placeholder = { Text("Имя") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        TextField(
            value = describe,
            onValueChange = fn_describe,
            placeholder = { Text("Описание") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0D47A1),
                backgroundColor = Color(0xFFC3DAFF),
                focusedLabelColor = Color(0xFF0D47A1),

                ),
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(51.dp)

        )
        Spacer(modifier = Modifier
            .align(Alignment.End)
            .height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = fn_button_cancel,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF0D47A1),
                    contentColor = Color(0xFFC3DAFF),
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp)
            ) {
                Text(text = "Отмена")
            }

            Button(
                onClick = fn_button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF0D47A1),
                    contentColor = Color(0xFFC3DAFF),
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp)
            ) {
                Text(text = "Добавить")
            }

        }

    }
}