package com.zhigaras.login.di

import com.zhigaras.cloudservice.di.cloudServiceModule
import com.zhigaras.login.domain.LoginFlowWrapper
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.login.ui.LoginViewModel
import org.koin.dsl.binds

fun loginModule() = cloudServiceModule() + module {
    
    viewModelOf(::LoginViewModel)
    
    factory { LoginFlowWrapper.Base() } binds arrayOf(
        LoginFlowWrapper.Mutable::class,
        LoginFlowWrapper.Collect::class,
        LoginFlowWrapper.Post::class
    )
}