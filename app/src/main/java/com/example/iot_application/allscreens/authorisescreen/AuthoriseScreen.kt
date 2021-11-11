package com.example.iot_application.allscreens.authorisescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun AuthoriseScreen(
    login: String,
    password: String,
    iotToken: String,
    fnLogin: (String) -> Unit,
    fnPassword: (String) -> Unit,
    fnPasswordVisibility: () -> Unit,
    fnButton: () -> Unit,
    passwordVisibility: Boolean

) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        ) {

        TextField(
            value = login, 
            onValueChange = fnLogin,
            modifier = Modifier.width(IntrinsicSize.Max)
        )
        Spacer(modifier = Modifier.align(Alignment.End).height(8.dp))
        TextField(
            value = password,
            onValueChange = fnPassword,
            label = { Text("Password") },
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = fnPasswordVisibility) {
                    Icon(imageVector  = image, "")
                }
            }
        )
        Spacer(modifier = Modifier.align(Alignment.End).height(8.dp))
        Button(
            onClick = fnButton,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Авторизация")
        }
    }
}

@Preview
@Composable
fun Prew1() {

    AuthoriseScreen(login = "login", password = "Password", fnLogin = {"login = it"}, fnPassword = {"password = it"} , fnButton = {}, fnPasswordVisibility = {}, passwordVisibility= false, iotToken ="")
    
}