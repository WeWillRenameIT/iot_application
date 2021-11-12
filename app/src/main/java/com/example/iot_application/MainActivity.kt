package com.example.iot_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.iot_application.allscreens.navigation.NavigationScreenState
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

//            Image(
//                painter = painterResource(id = R.drawable.iot1),
//                contentDescription = "",
//                Modifier.fillMaxSize()
//            )

            NavigationScreenState()
            //JournalScreenState()
            //UsersScreenState()
        }
    }
}

