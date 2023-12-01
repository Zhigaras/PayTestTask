package com.zhigaras.payments.domain

interface PaymentsRepository {
    
    suspend fun getPayments()
}