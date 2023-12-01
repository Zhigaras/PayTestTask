package com.zhigaras.login.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.login.domain.LoginFlowWrapper
import com.zhigaras.login.domain.LoginInteractor
import com.zhigaras.login.domain.LoginNavigation
import com.zhigaras.login.domain.LoginUiState
import com.zhigaras.tokenstorage.TokenStorage

class LoginViewModel(
    private val tokenStorage: TokenStorage,
    private val navigation: LoginNavigation,
    private val interactor: LoginInteractor,
    override val flowWrapper: LoginFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<LoginUiState>(dispatchers) {
    
    fun login(login: String, password: String) {
        flowWrapper.post(LoginUiState.Loading())
        scopeLaunch(
            onBackground = { interactor.login(login, password) },
            onUi = { it.handle(flowWrapper, navigation, tokenStorage) }
        )
    }
}