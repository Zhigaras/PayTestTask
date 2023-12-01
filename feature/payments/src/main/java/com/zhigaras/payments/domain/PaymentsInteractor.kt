package com.zhigaras.payments.domain

import com.zhigaras.cloudservice.model.PaymentDomain
import com.zhigaras.payments.ui.PaymentUi
import com.zhigaras.tokenstorage.TokenStorage

interface PaymentsInteractor {
    
    suspend fun getPayments(): List<PaymentUi>
    
    fun logout()
    
    class Base(
        private val repository: PaymentsRepository,
        private val tokenStorage: TokenStorage
    ) : PaymentsInteractor {
        override suspend fun getPayments(): List<PaymentUi> {
            val source = repository.getPayments()
            val grouped = source.groupBy { it.isTimeStampKnown() }
            val sortedPart = grouped[true].orEmpty()
                .map { it as PaymentDomain.CorrectTimeStamp }
                .sortedBy { it.created }
            val result = mutableListOf<PaymentUi>()
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