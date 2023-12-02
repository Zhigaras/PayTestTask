package com.zhigaras.tokenstorage

interface TokenStorage {
    
    fun save(token: String)
    
    fun getToken(): Token
    
    fun isLoggedIn(): Boolean
    
    fun removeToken()
}