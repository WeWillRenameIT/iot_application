package com.example.iot_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent

import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.navigation.NavigationBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: 11.11.2021 (тестовая навигация/проверка работы собранного приложения) СНЕСТИ НАХЕР ЭТОТ БЕСПРЕДЕЛ. РАЗБИТЬ НА ЭЛЕМЕНТЫ. ВЫНЕСТИ ИЗ MainActivity нахуй

        setContent {


            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screens.AuthoriseScreen.route) {
                composable(route = Screens.AuthoriseScreen.route ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {


                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                        ) {
                            Column() {
                                Text(text = "АВТОРИЗАЦИЯ")
                            }

                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter),
                        ) {
                            NavigationBar(navController = navController)
                        }

                    }

                }
                composable(route = Screens.UsersScreen.route) {

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {


                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                        ) {
                            Column() {
                                Text(text = "ПОЛЬЗОВАТЕЛИ")
                            }

                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter),
                        ) {
                            NavigationBar(navController = navController)
                        }

                    }

                }
                composable(route = Screens.CodeLocksScreen .route) {

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {


                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                        ) {
                            Column() {
                                Text(text = "ЗАМКИ")
                            }

                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter),
                        ) {
                            NavigationBar(navController = navController)
                        }

                    }

                }
                composable(route = Screens.JournalsScreen.route) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {


                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                        ) {
                            Column() {
                                Text(text = "ЖУРНАЛ")
                            }

                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter),
                        ) {
                            NavigationBar(navController = navController)
                        }

                    }

                }

            }


        }
    }
}

