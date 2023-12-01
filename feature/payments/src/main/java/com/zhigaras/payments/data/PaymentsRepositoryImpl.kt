package com.zhigaras.payments.data

import com.zhigaras.cloudservice.CloudService
import com.zhigaras.payments.domain.PaymentsRepository
import com.zhigaras.payments.domain.PaymentDomain

class PaymentsRepositoryImpl(private val cloudService: CloudService) : PaymentsRepository {
    
    override suspend fun getPayments(): List<PaymentDomain> {
        return cloudService.getPayments().payments.map { PaymentDomain.fromDto(it) }
    }
}