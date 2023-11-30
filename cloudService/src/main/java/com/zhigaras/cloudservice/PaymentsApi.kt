package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.LoginRequest
import com.zhigaras.cloudservice.model.LoginResponse
import com.zhigaras.cloudservice.model.PaymentsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PaymentsApi {
    
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
    
    @GET("/payments")
    suspend fun getPayments(): PaymentsResponse
}