package com.zhigaras.paytesttask.di

import com.zhigaras.core.Dispatchers
import com.zhigaras.core.ManageResources
import com.zhigaras.paytesttask.domain.MainFlowWrapper
import com.zhigaras.paytesttask.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

fun mainModule() = module {
    
    viewModelOf(::MainViewModel)
    
    factory { Dispatchers.Base() } bind Dispatchers::class
    
    factory { ManageResources.Base(androidContext()) } bind ManageResources::class
    
    factory { MainFlowWrapper.Base() } binds arrayOf(
        MainFlowWrapper.Mutable::class,
        MainFlowWrapper.Collect::class,
        MainFlowWrapper.Post::class
    )
}