package com.zhigaras.payments.domain

interface PaymentsInteractor {
    
    suspend fun getPayments()
    
    class Base(private val repository: PaymentsRepository) : PaymentsInteractor {
        override suspend fun getPayments() {
            return repository.getPayments()
        }
    }
}