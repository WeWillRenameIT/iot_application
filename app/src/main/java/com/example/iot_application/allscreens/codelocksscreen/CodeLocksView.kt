package com.example.iot_application.allscreens.codelocksscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
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
fun CodeLockScreenRow(
    id: Int,
    name: String,
    description: String,
    fnButton: ()->Unit
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
                .clickable(onClick = fnButton)
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
                    .weight(23f)
            ) {
                //Row(modifier = Modifier.weight(1.5f)) {}
                Row(
                    modifier = Modifier
                        .weight(11.2f)

                ) {
                    Text(
                        text = "Имя: $name",
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier
                    .weight(1f)
                    .padding(top = 1.dp, bottom = 1.dp, end = 10.dp))
                Row(
                    modifier = Modifier
                        .weight(11.2f)
                ) {

                    Text(
                        text = "Где: $description",
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }

            }


        }


    }
    Spacer(modifier = Modifier.height(15.dp))


}

@Preview
@Composable
fun prew3() {
    CodeLockScreenRow(id = 1, name = "codeLock1", description = "Кодовый замок у передней двери школы номер 10 восточного крыла",{})
}