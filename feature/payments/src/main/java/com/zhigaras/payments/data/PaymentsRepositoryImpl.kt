package com.zhigaras.payments.data

import com.zhigaras.cloudservice.CloudService
import com.zhigaras.payments.domain.PaymentsRepository
import com.zhigaras.cloudservice.model.PaymentDomain

class PaymentsRepositoryImpl(private val cloudService: CloudService) : PaymentsRepository {
    
    override suspend fun getPayments(): List<PaymentDomain> {
        return cloudService.getPayments().payments.map { it.toDomain() }
    }
}