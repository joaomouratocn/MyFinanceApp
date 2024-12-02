package br.com.devjmcn.myfinanceapp.ui.screens.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, logout: () -> Unit) {
    val viewModel = viewModel<HomeViewModel>()
    val goToSingIn by viewModel.goToSingIn.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCurrentUser()
    }

    when {
        goToSingIn -> {
            logout()
        }
    }

    Button(modifier = modifier, onClick = {
        viewModel.logout()
        logout()
    }) {
        Text(text = "Logout")
    }
}