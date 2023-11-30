package com.zhigaras.cloudservice

import com.zhigaras.tokenstorage.TokenStorage
import okhttp3.Interceptor
import okhttp3.Response

class MainInterceptor(private val storage: TokenStorage) : Interceptor {
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        
        storage.getToken().provideToken()?.let {
            requestBuilder.addHeader("token", it)
        }
        requestBuilder.addHeader("app-key", "12345")
        requestBuilder.addHeader("v", "1")
        
        return chain.proceed(requestBuilder.build())
    }
}