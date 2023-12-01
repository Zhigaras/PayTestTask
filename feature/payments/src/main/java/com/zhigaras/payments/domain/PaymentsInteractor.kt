package com.zhigaras.payments.domain

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
        private val tokenStorage: TokenStorage
    ) : PaymentsInteractor {
        override suspend fun getPayments(): PaymentsUiState {
            return try {
                val source = repository.getPayments()
                PaymentsUiState.Success(processList(source))
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                PaymentsUiState.Error(e.message ?: "Unknown error")
            }
        }
        
        private fun processList(source: List<PaymentDomain>): List<PaymentUi<*>> {
            val grouped = source.groupBy { it.isTimeStampKnown() }
            val sortedPart = grouped[true].orEmpty()
                .map { it as PaymentDomain.CorrectTimeStamp }
                .sortedBy { it.created }
            val result = mutableListOf<PaymentUi<*>>()
            var bufferedPayment: PaymentDomain.CorrectTimeStamp? = null
            sortedPart.forEachIndexed { index, payment ->
                if (payment.isNextDay(bufferedPayment)) {
                    bufferedPayment = payment
                    result.add(PaymentUi.Divider(payment.formattedDay()))
                }
                result.add(PaymentUi.Base(payment))
            }
            result.add(PaymentUi.Divider("Unknown date"))
            result.addAll(grouped[false].orEmpty().map { PaymentUi.Base(it) })
            return result
        }
        
        override fun logout() {
            tokenStorage.removeToken()
        }
    }
}