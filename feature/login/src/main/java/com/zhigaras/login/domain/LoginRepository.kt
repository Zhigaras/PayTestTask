package com.zhigaras.login.domain

import com.zhigaras.cloudservice.model.LoginResponse

interface LoginRepository {
    
    suspend fun login(login: String, password: String): LoginResponse
}