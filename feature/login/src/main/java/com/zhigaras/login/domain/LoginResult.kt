package com.zhigaras.login.domain

import com.zhigaras.core.Navigation
import com.zhigaras.payments.ui.PaymentsFragment
import com.zhigaras.tokenstorage.TokenStorage

interface LoginResult {
    
    fun handle(
        flowWrapper: LoginFlowWrapper.Post,
        navigation: Navigation,
        tokenStorage: TokenStorage
    )
    
    class Success(private val token: String) : LoginResult {
        override fun handle(
            flowWrapper: LoginFlowWrapper.Post,
            navigation: Navigation,
            tokenStorage: TokenStorage
        ) {
            tokenStorage.save(token)
            flowWrapper.post(LoginUiState.Success())
            navigation.goTo(PaymentsFragment::class.java)
        }
    }
    
    class Error(private val message: String) : LoginResult {
        override fun handle(
            flowWrapper: LoginFlowWrapper.Post,
            navigation: Navigation,
            tokenStorage: TokenStorage
        ) {
            flowWrapper.post(LoginUiState.Error(message))
        }
    }
}