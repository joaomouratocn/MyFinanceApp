package br.com.devjmcn.myfinanceapp.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.devjmcn.myfinanceapp.ui.composes.LoadProgressBar
import br.com.devjmcn.myfinanceapp.ui.theme.MyFinanceAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goToSingIn: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val showProgressBar by viewModel.showProgressBar.collectAsState()
    val goToSingIn by viewModel.goToSingIn.collectAsState()

    if (showProgressBar) {
        LoadProgressBar(modifier = Modifier)
    }

    when {
        showProgressBar -> LoadProgressBar()
        goToSingIn -> goToSingIn()
    }

}

@Preview
@Composable
private fun HomeScreenPreview() {
    MyFinanceAppTheme {
        HomeScreen(
            modifier = Modifier,
            goToSingIn = {}
        )
    }
}