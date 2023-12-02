package com.zhigaras.tokenstorage.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.zhigaras.tokenstorage.TokenStorage
import com.zhigaras.tokenstorage.TokenStorageImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.bind
import org.koin.dsl.module

fun tokenStorageModule() = module {
    
    factory { TokenStorageImpl(get()) } bind TokenStorage::class
    
    single {
        val masterKey = MasterKey.Builder(androidApplication())
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        EncryptedSharedPreferences.create(
            androidApplication(),
            "tokenStorage",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}