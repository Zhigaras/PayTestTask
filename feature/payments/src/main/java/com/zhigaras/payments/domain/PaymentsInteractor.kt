package com.zhigaras.payments.domain

import com.zhigaras.tokenstorage.TokenStorage

interface PaymentsInteractor {
    
    suspend fun getPayments()
    
    fun logout()
    
    class Base(
        private val repository: PaymentsRepository,
        private val tokenStorage: TokenStorage
    ) : PaymentsInteractor {
        override suspend fun getPayments() {
            return repository.getPayments()
        }
        
        override fun logout() {
            tokenStorage.removeToken()
        }
    }
}