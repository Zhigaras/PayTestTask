package com.zhigaras.login.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.login.domain.LoginFlowWrapper
import com.zhigaras.login.domain.LoginUiState

class LoginViewModel(
    override val flowWrapper: LoginFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<LoginUiState>(dispatchers) {


}