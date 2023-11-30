package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.LoginRequest
import com.zhigaras.cloudservice.model.LoginResponse
import com.zhigaras.cloudservice.model.PaymentsResponse

class CloudServiceImpl(private val api: PaymentsApi) : CloudService {
    
    override suspend fun login(login: String, password: String): LoginResponse {
        return api.login(LoginRequest(login, password))
    }
    
    override suspend fun getPayments(): PaymentsResponse {
        return api.getPayments()
    }
}