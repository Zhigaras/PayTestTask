package com.zhigaras.tokenstorage.di

import android.content.Context
import com.zhigaras.tokenstorage.TokenStorage
import com.zhigaras.tokenstorage.TokenStorageImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.bind
import org.koin.dsl.module

fun tokenStorageModule() = module {
    
    factory { TokenStorageImpl(get()) } bind TokenStorage::class
    
    single { androidApplication().getSharedPreferences("tokenStorage", Context.MODE_PRIVATE) }
}