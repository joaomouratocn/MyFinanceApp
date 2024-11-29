package br.com.devjmcn.myfinanceapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.devjmcn.myfinanceapp.ui.screens.ForgotPasswordScreen
import br.com.devjmcn.myfinanceapp.ui.screens.home.HomeScreen
import br.com.devjmcn.myfinanceapp.ui.screens.singIn.SingInScreen
import br.com.devjmcn.myfinanceapp.ui.screens.singUp.SingUpScreen

@Composable
fun NavigationApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "SIGN-IN") {
        composable("SIGN-IN") {
            SingInScreen(
                modifier = modifier,
                onSingInClick = {
                    navController.navigate("HOME") {
                        popUpTo("SIGN-IN") { inclusive = true }
                    }
                },
                onSignUpClick = { navController.navigate("SIGN-UP") },
                onForgotPasswordClick = {navController.navigate("FORGOT-PASSWORD")}
            )
        }

        composable("SIGN-UP") {
            SingUpScreen(modifier = modifier)
        }

        composable("FORGOT-PASSWORD"){ ForgotPasswordScreen(modifier = modifier) }

        composable("HOME") {
            HomeScreen(modifier = modifier)
        }
    }
}