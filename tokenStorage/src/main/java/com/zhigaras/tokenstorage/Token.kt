package com.zhigaras.tokenstorage

interface Token {
    
    fun isNotEmpty(): Boolean
    
    fun provideToken(): String?
    
    class Empty : Token {
        override fun isNotEmpty() = false
        override fun provideToken() = null
    }
    
    class Base(private val token: String) : Token {
        override fun isNotEmpty() = true
        override fun provideToken() = token
    }
}