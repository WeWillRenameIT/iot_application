package com.example.iot_application.allscreens.addscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DetailAddViewState(
    showDialog: Boolean,
    fnShowDialog: (Boolean) -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = {}) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(400.dp)
                    .height(450.dp)
                    .background(Color.White)
                    .padding(bottom = 7.dp)
            ) {
                Button(onClick = {fnShowDialog(false)}) {
                    Text(text = "Во")
                }
            }
        }
    }

    
}