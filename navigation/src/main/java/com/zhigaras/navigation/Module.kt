package com.zhigaras.navigation

import com.zhigaras.login.di.loginModule
import com.zhigaras.login.domain.LoginNavigation
import com.zhigaras.payments.domain.PaymentsNavigation
import org.koin.dsl.binds
import org.koin.dsl.module

fun navigationModule() = loginModule() + module {
    
    single { NavigationImpl() } binds arrayOf(
        Navigation::class,
        StartNavigation::class,
        LoginNavigation::class,
        PaymentsNavigation::class
    )
}