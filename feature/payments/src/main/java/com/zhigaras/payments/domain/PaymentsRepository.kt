package com.zhigaras.payments.domain

import com.zhigaras.cloudservice.model.PaymentDomain

interface PaymentsRepository {
    
    suspend fun getPayments(): List<PaymentDomain>
}