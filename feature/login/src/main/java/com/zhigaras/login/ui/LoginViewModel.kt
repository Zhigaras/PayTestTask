package com.zhigaras.login.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.login.domain.LoginFlowWrapper
import com.zhigaras.login.domain.LoginInteractor
import com.zhigaras.login.domain.LoginUiState

class LoginViewModel(
    private val navigation: Navigation,
    private val interactor: LoginInteractor,
    override val flowWrapper: LoginFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<LoginUiState>(dispatchers) {
    
    fun login(login: String, password: String) {
        flowWrapper.post(LoginUiState.Loading())
        scopeLaunch(
            onBackground = { interactor.login(login, password) },
            onUi = { it.handle(flowWrapper, navigation) }
        )
    }
}