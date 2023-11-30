package com.zhigaras.paytesttask

import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.core.NavigationImpl
import org.koin.dsl.bind
import org.koin.dsl.module

fun mainModule() = module {
    
    factory { Dispatchers.Base() } bind Dispatchers::class
    
    single { NavigationImpl() } bind Navigation::class
}