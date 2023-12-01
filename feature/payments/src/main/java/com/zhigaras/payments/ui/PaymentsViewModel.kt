package com.zhigaras.payments.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.payments.domain.PaymentsFlowWrapper
import com.zhigaras.payments.domain.PaymentsInteractor
import com.zhigaras.payments.domain.PaymentsUiState

class PaymentsViewModel(
    private val navigation: Navigation,
    private val interactor: PaymentsInteractor,
    override val flowWrapper: PaymentsFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<PaymentsUiState>(dispatchers) {
    
    fun logout() {
        interactor.logout()
        // TODO: go to login
    }
    
}