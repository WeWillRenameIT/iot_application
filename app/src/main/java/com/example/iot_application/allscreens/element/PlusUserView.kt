package com.example.iot_application.allscreens.journalscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun PlusUserView(
    fnButton:()-> Unit
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 30.dp, bottom = 100.dp)
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(45.dp)
                .background(Color.Transparent)
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    clip = true
                )

                .clickable { fnButton }

        ) {
            Box(
                modifier = Modifier
                    .padding()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "+", fontSize = 30.sp, color = Color(0xFF51A84B))
            }
        }
    }
}

@Preview
@Composable
fun Pre1() {


    PlusUserView({})
}