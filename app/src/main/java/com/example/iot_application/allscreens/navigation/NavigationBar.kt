package com.example.iot_application.allscreens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.People
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.iot_application.allscreens.Screens


// TODO: 10.11.2021 ИЗМЕНИТЬ НА НОРМАЛЬНЫЙ ЭЛЕМЕНТ НАВИГАЦИИ
@Composable
fun NavigationBar(
    fnPeople: () -> Unit,
    fnList: () -> Unit,
    fnLock: () -> Unit,
    selectedScreen: Int
) {

    BottomNavigation() {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.People, contentDescription = null) },
            label = { Text("Люди") },
            selected = (selectedScreen == 1),
            onClick = fnPeople
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.List, contentDescription = null) },
            label = { Text("Журнал") },
            selected = (selectedScreen == 2),
            onClick = fnList
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Lock, contentDescription = null) },
            label = { Text("Замки") },
            selected = (selectedScreen == 3),
            onClick = fnLock
        )
    }


}

@Preview
@Composable
fun Prew2() {

    var x by remember { mutableStateOf(1) }
    NavigationBar(fnPeople = { x = 1 }, fnList = { x = 2 }, fnLock = { x = 3 }, selectedScreen = x)
}