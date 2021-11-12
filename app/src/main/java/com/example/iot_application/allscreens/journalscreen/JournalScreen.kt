package com.example.iot_application.allscreens.journalscreen

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
import java.sql.Timestamp

@Composable
fun JournalScreenRow(
    id: Int,
    userId: Int,
    codeLockName: String,
    fio: String,
    timestamp: String,
    result: String
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()

        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(20f)
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
                            text = codeLockName,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 14.sp

                        )
                        Text(
                            text = fio,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.sp
                        )
                    }

                    Text(
                        text = timestamp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(6f)

                    )

                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(if (result == "Успешно") Color(0xFF51A84B) else Color(0xFFA53035),)
            ) {

            }
        }
    }
    Spacer(modifier = Modifier.height(15.dp))


}

@Preview
@Composable
fun prew3() {
    JournalScreenRow(id = 1, userId = 2, codeLockName = "Дверь 1", fio = "Иван Иванович Иванов", timestamp = "2021-07-01 06:30:30", result = "Удачно")
}