package br.com.devjmcn.myfinanceapp.ui.screens.singIn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.HighlightOff
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.devjmcn.myfinanceapp.R
import br.com.devjmcn.myfinanceapp.ui.composes.Dialog
import br.com.devjmcn.myfinanceapp.ui.composes.StatusBarIconsColorWhite
import br.com.devjmcn.myfinanceapp.ui.composes.TextErrorMessage
import br.com.devjmcn.myfinanceapp.ui.composes.WaveBackground
import br.com.devjmcn.myfinanceapp.ui.theme.MyFinanceAppTheme
import br.com.devjmcn.myfinanceapp.util.VerifyNetwork

@Composable
fun SingInScreen(
    modifier: Modifier = Modifier,
    onSingInClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    val viewModel = viewModel<SingInViewModel>()
    val keyBoardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    var openDialog by remember { mutableStateOf(false) }
    var isConnected by remember { mutableStateOf(true) }
    val singIn by viewModel.goToHome.collectAsState()

    LaunchedEffect(Unit) {
        isConnected = VerifyNetwork.isInternetAvailable(context = context)
    }

    Box {
        StatusBarIconsColorWhite(modifier = Modifier)
        WaveBackground(modifier = Modifier)

        if (!isConnected) {
            openDialog = true
        }

        when {
            openDialog -> {
                Dialog(
                    confirmText = stringResource(R.string.str_ok),
                    onConfirmation = {
                        isConnected = VerifyNetwork.isInternetAvailable(context)
                        openDialog = false
                    },
                    onDismissRequest = null,
                    dialogTitle = stringResource(R.string.str_connection_error),
                    dialogText = stringResource(R.string.str_verify_network),
                    icon = Icons.Default.HighlightOff,
                    iconColor = Color.Red,
                    iconContentDescription = "Image content description"
                )
            }

            singIn ->{
                onSingInClick()
            }
        }

        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.str_sing_in),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 28.sp,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 30.dp)
            )

            val emailValue by viewModel.email.collectAsState()
            val isValidEmail by viewModel.isValidEmail.collectAsState()
            val emailErrorMessage by viewModel.emailErrorMessage.collectAsState()

            Column(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = emailValue,
                    onValueChange = { newString -> viewModel.updateValueEmail(newString) },
                    label = { Text(stringResource(R.string.str_email_address)) },
                    trailingIcon = {
                        if (isValidEmail) {
                            Icon(
                                Icons.Default.Check,
                                tint = Color(0xFF2196F3),
                                contentDescription = stringResource(R.string.str_image_email_ok),
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    isError = emailErrorMessage != "",
                    modifier = Modifier.fillMaxWidth()
                )
                TextErrorMessage(
                    text = emailErrorMessage,
                )
            }

            val passValue by viewModel.password.collectAsState()
            val passwordErrorMessage by viewModel.passwordErrorMessage.collectAsState()

            var seePassword by remember {
                mutableStateOf(false)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 30.dp
                    )
            ) {
                TextField(
                    value = passValue,
                    onValueChange = { newString -> viewModel.updateValuePassword(newString) },
                    label = { Text(stringResource(R.string.str_password)) },
                    visualTransformation = if (seePassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Icon(
                            imageVector = if (seePassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = stringResource(R.string.str_image_see_password),
                            modifier = Modifier.clickable { seePassword = !seePassword }
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                TextErrorMessage(
                    text = passwordErrorMessage,
                )
            }

            Text(
                text = stringResource(R.string.str_forgot_password),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = if (isSystemInDarkTheme()) Color.Cyan else Color.Blue,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 30.dp)
                    .clickable { onForgotPasswordClick() }
            )

            Button(
                onClick = {
                    keyBoardController?.hide()
                    viewModel.validateFields()
                },
                modifier = Modifier
                    .padding(30.dp)
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.str_sign_in))
            }

            Button(
                onClick = { onSignUpClick() },
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.str_sign_up))
            }
        }
    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    MyFinanceAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SingInScreen(
                modifier = Modifier.padding(innerPadding),
                onSingInClick = {},
                onSignUpClick = {},
                onForgotPasswordClick = {}
            )
        }
    }
}