package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.LoginResponse
import com.zhigaras.cloudservice.model.PaymentsResponse

interface CloudService {
    
    suspend fun login(login: String, password: String): LoginResponse
    
    suspend fun getPayments(): PaymentsResponse
}