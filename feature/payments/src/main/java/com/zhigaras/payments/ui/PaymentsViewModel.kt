package com.zhigaras.payments.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.payments.domain.PaymentsFlowWrapper
import com.zhigaras.payments.domain.PaymentsInteractor
import com.zhigaras.payments.domain.PaymentsNavigation
import com.zhigaras.payments.domain.PaymentsUiState

class PaymentsViewModel(
    private val navigation: PaymentsNavigation,
    private val interactor: PaymentsInteractor,
    override val flowWrapper: PaymentsFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<PaymentsUiState>(dispatchers) {
    
    fun logout() {
        interactor.logout()
        navigation.fromPaymentsToLogin()
    }
    
}