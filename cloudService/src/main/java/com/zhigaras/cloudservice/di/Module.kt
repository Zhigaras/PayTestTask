package com.zhigaras.cloudservice.di

import com.zhigaras.cloudservice.CloudService
import com.zhigaras.cloudservice.CloudServiceImpl
import com.zhigaras.cloudservice.MainInterceptor
import com.zhigaras.cloudservice.PaymentsApi
import com.zhigaras.tokenstorage.di.tokenStorageModule
import okhttp3.OkHttpClient
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun cloudServiceModule() = tokenStorageModule() + module {
    
    factory {
        Retrofit.Builder()
            .baseUrl(PaymentsApi.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    factory {
        OkHttpClient.Builder()
            .addInterceptor(MainInterceptor(get()))
            .build()
    }
    
    factory { get<Retrofit>().create(PaymentsApi::class.java) } bind PaymentsApi::class
    
    factory { CloudServiceImpl(get()) } bind CloudService::class
}