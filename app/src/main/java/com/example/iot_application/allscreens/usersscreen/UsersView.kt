package com.example.iot_application.allscreens.usersscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScreenRow(
    id: Int,
    role: Int,
    username: String,
    fnButton: ()->Unit
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White)
            .clickable(onClick = fnButton)


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(2f)
            ) {
                Text(
                    text = "$id",
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }
            Column(
                verticalArrangement = Arrangement.Center,
                //horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(15f)
            ) {
                Text(
                    text = username,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp

                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(8f)
            ) {
                Text(
                    text = when (role) {
                        2 -> "Администратор"
                        1 -> "Модератор"
                        else -> "Работник"
                    },
                    fontWeight = FontWeight(500),
                    color = when (role) {
                        2 -> Color(0xFFC5523E)
                        1 -> Color(0xFF2E4FA3)
                        else -> Color(0xFF000000)
                    },
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    modifier = Modifier.width(100.dp)
                )
            }

        }

    }
    Spacer(modifier = Modifier.height(15.dp))
}


@Preview
@Composable
fun prew3() {
    UserScreenRow(id = 1, role = 0, username = "Иваннов Иван Иванович", {})
}

@Preview
@Composable
fun prew4() {
    UserScreenRow(id = 2, role = 1, username = "Иваннов Иван Иванович", {})
}

@Preview
@Composable
fun prew5() {
    UserScreenRow(id = 3, role = 2, username = "Иваннов Иван Иванович", {})
}