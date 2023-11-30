package com.zhigaras.login.domain

import com.zhigaras.core.Navigation

interface LoginResult {
    
    fun handle(flowWrapper: LoginFlowWrapper.Post, navigation: Navigation)
    
    class Success(private val token: String) : LoginResult {
        override fun handle(flowWrapper: LoginFlowWrapper.Post, navigation: Navigation) {
            // TODO: save token
            flowWrapper.post(LoginUiState.Success())
            // TODO: navigate
        }
    }
    
    class Error(private val message: String) : LoginResult {
        override fun handle(flowWrapper: LoginFlowWrapper.Post, navigation: Navigation) {
            flowWrapper.post(LoginUiState.Error(message))
        }
    }
}