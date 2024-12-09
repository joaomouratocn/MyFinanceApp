package br.com.devjmcn.myfinanceapp.di

import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.data.firebase.FireBaseAuth
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module{
    singleOf(::FireBaseAuth){bind<Repository>()}
}