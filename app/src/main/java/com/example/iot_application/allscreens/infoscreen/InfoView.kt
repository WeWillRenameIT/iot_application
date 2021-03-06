package com.example.iot_application.allscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoScreen(
    fnButton: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Surface(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(220.dp)
                .background(Color.White)
                .padding(15.dp)

        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Информация",fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(text = "Группа: ИВБО-05-18",fontSize = 16.sp, modifier = Modifier.padding(top = 5.dp))
                Text(text = "Передерий Владимир",fontSize = 16.sp, modifier = Modifier.padding(top = 5.dp))
                Text(text = "Иваннов Дмитрий",fontSize = 16.sp, modifier = Modifier.padding(top = 5.dp))
                Text(text = "Мурашев Александр",fontSize = 16.sp, modifier = Modifier.padding(top = 5.dp))
                Text(text = "Капырин Константин",fontSize = 16.sp, modifier = Modifier.padding(top = 5.dp))
                Text(text = "Чернышев Владислав",fontSize = 16.sp, modifier = Modifier.padding(top = 5.dp))

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = fnButton,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFD8353C),
                contentColor = Color(0xFFFFFFFF),
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(40.dp)
                .width(150.dp)
        ) {
            Text(text = "Выйти",fontSize = 16.sp)
        }
    }

}


@Preview
@Composable
fun prew4() {
    InfoScreen({})
}