package br.com.devjmcn.myfinanceapp.ui.screens.forgotPassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devjmcn.myfinanceapp.R
import br.com.devjmcn.myfinanceapp.ui.theme.MyFinanceAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    viewModel: ForgotPasswordViewModel = koinViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(stringResource(R.string.str_enter_your_email_address))

        val inputEmail by viewModel.inputEmail.collectAsState()
        TextField(
            value = inputEmail,
            onValueChange = { newString -> viewModel.updateInputEmail(newString) },
            label = { Text(stringResource(R.string.str_email)) },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        {
            Button(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                onClick = {}
            ) {
                Text(stringResource(R.string.str_cancel))
            }

            Button(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                onClick = {}
            ) {
                Text(stringResource(R.string.str_send_email))
            }
        }
    }
}

@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    MyFinanceAppTheme {
        ForgotPasswordScreen()
    }
}