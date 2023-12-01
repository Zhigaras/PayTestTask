package com.zhigaras.tokenstorage

import android.content.SharedPreferences

class TokenStorageImpl(private val prefs: SharedPreferences) : TokenStorage {
    
    override fun save(token: String) {
        prefs.edit().putString(TOKEN_KEY, token).apply()
    }
    
    override fun getToken(): Token {
        val token = prefs.getString(TOKEN_KEY, "")
        return if (token == "" || token == null) Token.Empty() else Token.Base(token)
    }
    
    override fun isLoggedIn(): Boolean {
        return getToken().isNotEmpty()
    }
    
    override fun removeToken() {
        prefs.edit().remove(TOKEN_KEY).apply()
    }
    
    companion object {
        private const val TOKEN_KEY = "tokenKey"
    }
}