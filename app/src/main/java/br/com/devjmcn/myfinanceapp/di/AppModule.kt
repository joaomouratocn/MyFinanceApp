package br.com.devjmcn.myfinanceapp.di

import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.data.firebase.FireBaseAuth
import br.com.devjmcn.myfinanceapp.ui.screens.home.HomeViewModel
import br.com.devjmcn.myfinanceapp.ui.screens.singIn.SingInViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { FireBaseAuth() }
    viewModel { SingInViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}