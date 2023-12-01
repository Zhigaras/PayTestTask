package com.zhigaras.payments.data

import com.zhigaras.cloudservice.CloudService
import com.zhigaras.payments.domain.PaymentsRepository

class PaymentsRepositoryImpl(private val cloudService: CloudService) : PaymentsRepository {
    
    override suspend fun getPayments() {
        cloudService.getPayments()
    }
}