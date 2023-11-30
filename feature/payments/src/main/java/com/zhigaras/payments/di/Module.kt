package com.zhigaras.payments.di

import com.zhigaras.payments.domain.PaymentsFlowWrapper
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.payments.ui.PaymentsViewModel
import org.koin.dsl.binds

fun paymentsModule() = module {
    
    viewModelOf(::PaymentsViewModel)
    
    factory { PaymentsFlowWrapper.Base() } binds arrayOf(
        PaymentsFlowWrapper.Mutable::class,
        PaymentsFlowWrapper.Post::class,
        PaymentsFlowWrapper.Collect::class
    )
}