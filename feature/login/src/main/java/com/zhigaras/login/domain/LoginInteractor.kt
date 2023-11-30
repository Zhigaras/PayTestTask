package com.zhigaras.login.domain

import kotlin.coroutines.cancellation.CancellationException

interface LoginInteractor {
    
    suspend fun login(login: String, password: String): LoginResult
    
    class Base(private val repository: LoginRepository) : LoginInteractor {
        
        override suspend fun login(login: String, password: String): LoginResult {
            try {
                val response = repository.login(login, password)
                response.token?.let { return LoginResult.Success(it.token) }
                response.error?.let { return LoginResult.Error(it.errorMsg) }
                throw Exception()
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                return LoginResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}