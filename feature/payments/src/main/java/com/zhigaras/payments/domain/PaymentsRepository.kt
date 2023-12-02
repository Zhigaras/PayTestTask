package com.zhigaras.payments.domain

import com.zhigaras.payments.domain.model.PaymentDomain

interface PaymentsRepository {
    
    suspend fun getPayments(): List<PaymentDomain>
}