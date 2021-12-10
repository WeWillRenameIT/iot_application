package com.example.iot_application.allscreens.journalscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
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
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(15f)
                    ) {
                        //Row(modifier = Modifier.weight(1.5f)) {}
                        Row(
                            modifier = Modifier
                                .weight(7.2f)

                        ) {
                            Text(
                                text = "Где: $codeLockName",
                                fontWeight = FontWeight(500),
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier
                            .weight(0.6f)
                            .padding(top = 1.dp, bottom = 1.dp))
                        Row(
                            modifier = Modifier
                                .weight(7.2f)
                        ) {

                            Text(
                                text = "Kтo: ${if(fio!="") fio else "Неизвестно"}",
                                fontWeight = FontWeight(500),
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )

                        }

                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(7f)
                    ) {
                        Text(
                            text = timestamp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.sp,
                            modifier = Modifier.width(70.dp)

                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .background(if (result == "Успешная попытка") Color(0xFF51A84B) else Color(0xFFD8353C),)
                    ) {

                    }
                }
            }

        }
    }
    Spacer(modifier = Modifier.height(15.dp))


}

@Preview
@Composable
fun prew3() {
    JournalScreenRow(id = 1, userId = 2, codeLockName = "Кодовый замок у передней двери школы номер 10 восточного крыла", fio = "Кто: Чернышев Владислав Венианимович", timestamp = "2021-07-01 06:30:30", result = "Удачно")
}