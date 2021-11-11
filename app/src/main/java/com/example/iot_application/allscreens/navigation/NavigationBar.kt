package com.example.iot_application.allscreens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.iot_application.allscreens.Screens


// TODO: 10.11.2021 ИЗМЕНИТЬ НА НОРМАЛЬНЫЙ ЭЛЕМЕНТ НАВИГАЦИИ
@Composable
fun NavigationBar(
    navController: NavController,
    //iotToken: String
) {


    Column() {


        Surface(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .background(Color.White)
                .height(60.dp)
                .padding(top = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Surface(
                    shape = RoundedCornerShape(10.dp),

                    modifier = Modifier
                        //.background(Color.Gray)
                        .height(40.dp)
                        .shadow(15.dp, RoundedCornerShape(5.dp))
                        //.fillMaxWidth()
                        .width(100.dp)
                        .clickable {
                            navController.navigate(Screens.UsersScreen.route)
                        }
                ) {
                    Text(
                        text = "Люди",
                        //color = Color.Blue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        //.background(Color.Gray)
                        .height(40.dp)
                        .shadow(15.dp, RoundedCornerShape(5.dp))
                        //.fillMaxWidth()
                        .width(100.dp)
                        .clickable {
                            navController.navigate(Screens.JournalScreen.route)
//                            navController.navigate(
//                                "journal/${iotToken}",
//                                )

                        }
                ) {
                    Text(
                        text = "Журнал",
                        //color = Color.Blue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 10.dp))
                }
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        //background(Color.Gray)
                        .height(40.dp)
                        .shadow(15.dp, RoundedCornerShape(5.dp))
                        .width(100.dp)
                        .clickable {
                            navController.navigate(Screens.CodeLocksScreen.route)
                        }
                ) {
                    Text(
                        text = "Замки",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }

            }
        }

    }
}