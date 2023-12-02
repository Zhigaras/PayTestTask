package com.zhigaras.tokenstorage.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.zhigaras.tokenstorage.TokenStorage
import com.zhigaras.tokenstorage.TokenStorageImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.bind
import org.koin.dsl.module

fun tokenStorageModule() = module {
    
    factory { TokenStorageImpl(get()) } bind TokenStorage::class
    
    single {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        EncryptedSharedPreferences.create(
            "tokenStorage",
            masterKeyAlias,
            androidApplication(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}