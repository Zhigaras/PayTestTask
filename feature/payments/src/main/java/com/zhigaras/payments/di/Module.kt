package com.zhigaras.payments.di

import com.zhigaras.payments.data.PaymentsRepositoryImpl
import com.zhigaras.payments.domain.PaymentsFlowWrapper
import com.zhigaras.payments.domain.PaymentsInteractor
import com.zhigaras.payments.domain.PaymentsRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.payments.ui.PaymentsViewModel
import org.koin.dsl.bind
import org.koin.dsl.binds

fun paymentsModule() = module {
    
    viewModelOf(::PaymentsViewModel)
    
    factory { PaymentsFlowWrapper.Base() } binds arrayOf(
        PaymentsFlowWrapper.Mutable::class,
        PaymentsFlowWrapper.Post::class,
        PaymentsFlowWrapper.Collect::class
    )
    
    factory { PaymentsInteractor.Base(get(), get()) } bind PaymentsInteractor::class
    
    factory { PaymentsRepositoryImpl(get()) } bind PaymentsRepository::class
}