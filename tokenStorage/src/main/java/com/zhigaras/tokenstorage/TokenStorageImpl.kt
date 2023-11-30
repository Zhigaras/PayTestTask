package com.zhigaras.tokenstorage

import android.content.SharedPreferences

class TokenStorageImpl(private val prefs: SharedPreferences) : TokenStorage {
    
    override fun save(token: String) {
        prefs.edit().putString(TOKEN_KEY, token).apply()
    }
    
    override fun getToken(): String {
        return prefs.getString(TOKEN_KEY, "") ?: ""
    }
    
    override fun isLoggedIn(): Boolean {
        return getToken() != ""
    }
    
    companion object {
        private const val TOKEN_KEY = "tokenKey"
    }
}