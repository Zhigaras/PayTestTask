package com.zhigaras.cloudservice

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

//        token?.let {
//            requestBuilder.addHeader("Authorization", "bearer $it")
//        }
        
        return chain.proceed(requestBuilder.build())
    }
}