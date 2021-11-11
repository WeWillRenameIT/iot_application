package com.example.iot_application.allscreens.codelocksscreen

import androidx.compose.foundation.background
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
fun CodeLockScreenRow(
    id: Int,
    name: String,
    description: String,
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
                            text = name,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 14.sp

                        )
                        Text(
                            text = description,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp
                        )
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
    CodeLockScreenRow(id = 1, name = "codeLock1", description = "Дверь 1")
}