package br.com.devjmcn.myfinanceapp.ui.composes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextErrorMessage(modifier: Modifier = Modifier, text: String) {
    if (text != "") {
        Text(
            text = text,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = modifier.padding(start = 8.dp)
        )
    }
}