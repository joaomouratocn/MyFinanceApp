package br.com.devjmcn.myfinanceapp

import android.app.Application
import br.com.devjmcn.myfinanceapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyFinanceApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyFinanceApplication)
            modules(appModule)
        }
    }
}