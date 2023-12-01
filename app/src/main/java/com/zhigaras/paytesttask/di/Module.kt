package com.zhigaras.paytesttask.di

import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.core.NavigationImpl
import com.zhigaras.paytesttask.R
import com.zhigaras.paytesttask.domain.MainFlowWrapper
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.zhigaras.paytesttask.ui.MainViewModel
import org.koin.dsl.binds

fun mainModule() = module {
    
    viewModelOf(::MainViewModel)
    
    factory { Dispatchers.Base() } bind Dispatchers::class
    
    single { NavigationImpl(R.id.container) } bind Navigation::class
    
    factory { MainFlowWrapper.Base() } binds arrayOf(
        MainFlowWrapper.Mutable::class,
        MainFlowWrapper.Collect::class,
        MainFlowWrapper.Post::class
    )
}