package com.zhigaras.tokenstorage

interface TokenStorage {
    
    fun save(token: String)
    
    fun getToken(): String
    
    fun isLoggedIn(): Boolean
}