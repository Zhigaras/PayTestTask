package com.zhigaras.login.data

import com.zhigaras.cloudservice.CloudService
import com.zhigaras.cloudservice.model.LoginResponse
import com.zhigaras.login.domain.LoginRepository

class LoginRepositoryImpl(private val cloudService: CloudService) : LoginRepository {
    
    override suspend fun login(login: String, password: String): LoginResponse {
        return cloudService.login(login, password)
    }
}