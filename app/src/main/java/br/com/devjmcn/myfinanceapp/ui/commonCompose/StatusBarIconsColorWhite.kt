package br.com.devjmcn.myfinanceapp.ui.commonCompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun StatusBarIconsColorWhite(modifier: Modifier) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = Color.Transparent, // Deixa a barra de status transparente
        darkIcons = false // Define ícones claros (brancos)
    )
}