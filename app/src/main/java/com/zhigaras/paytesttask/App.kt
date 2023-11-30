package com.zhigaras.paytesttask

import android.app.Application
import com.zhigaras.login.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(mainModule()) + loginModule())
        }
    }
}