package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.LoginResponse
import com.zhigaras.cloudservice.model.PaymentsResponse

interface CloudService {
    
    fun login(): LoginResponse
    
    fun getPayments(): PaymentsResponse
}