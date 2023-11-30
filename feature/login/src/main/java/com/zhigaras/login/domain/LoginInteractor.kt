package com.zhigaras.login.domain

import kotlin.coroutines.cancellation.CancellationException

interface LoginInteractor {
    
    suspend fun login(login: String, password: String): LoginResult
    
    class Base(private val repository: LoginRepository) : LoginInteractor {
        
        override suspend fun login(login: String, password: String): LoginResult {
            return try {
                val response = repository.login(login, password)
                response.token?.let { LoginResult.Success(it.token) }
                response.error?.let { LoginResult.Error(it.errorMsg) }
                throw Exception()
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                LoginResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}