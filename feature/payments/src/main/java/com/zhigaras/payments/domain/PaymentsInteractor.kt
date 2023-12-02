package com.zhigaras.payments.domain

import com.zhigaras.core.ManageResources
import com.zhigaras.payments.domain.model.PaymentDomain
import com.zhigaras.payments.ui.PaymentUi
import com.zhigaras.payments.ui.PaymentsUiState
import com.zhigaras.tokenstorage.TokenStorage
import kotlin.coroutines.cancellation.CancellationException

interface PaymentsInteractor {
    
    suspend fun getPayments(): PaymentsUiState
    
    fun logout()
    
    class Base(
        private val repository: PaymentsRepository,
        private val tokenStorage: TokenStorage,
        private val resources: ManageResources
    ) : PaymentsInteractor {
        override suspend fun getPayments(): PaymentsUiState {
            return try {
                val source = repository.getPayments()
                PaymentsUiState.Success(processPayments(source), source.sumOf { it.amount.amount() })
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                PaymentsUiState.Error(e.message ?: "Unknown error")
            }
        }
        
        private fun processPayments(source: List<PaymentDomain>): List<PaymentUi<*>> {
            return source.groupBy { it.formattedDay(resources) }
                .flatMap { (created, list) ->
                    listOf(PaymentUi.Divider(created)) + list.map { PaymentUi.Base(it) }
                }
        }
        
        override fun logout() {
            tokenStorage.removeToken()
        }
    }
}