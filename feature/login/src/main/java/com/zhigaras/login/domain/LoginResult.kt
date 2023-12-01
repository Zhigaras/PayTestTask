package com.zhigaras.login.domain

import com.zhigaras.tokenstorage.TokenStorage

interface LoginResult {
    
    fun handle(
        flowWrapper: LoginFlowWrapper.Post,
        navigation: LoginNavigation,
        tokenStorage: TokenStorage
    )
    
    class Success(private val token: String) : LoginResult {
        override fun handle(
            flowWrapper: LoginFlowWrapper.Post,
            navigation: LoginNavigation,
            tokenStorage: TokenStorage
        ) {
            tokenStorage.save(token)
            flowWrapper.post(LoginUiState.Success())
            navigation.fromLoginToPayments()
        }
    }
    
    class Error(private val message: String) : LoginResult {
        override fun handle(
            flowWrapper: LoginFlowWrapper.Post,
            navigation: LoginNavigation,
            tokenStorage: TokenStorage
        ) {
            flowWrapper.post(LoginUiState.Error(message))
        }
    }
}