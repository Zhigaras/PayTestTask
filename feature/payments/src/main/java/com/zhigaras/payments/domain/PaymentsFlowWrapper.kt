package com.zhigaras.payments.domain

import com.zhigaras.core.FlowWrapper
import com.zhigaras.payments.ui.PaymentsUiState

interface PaymentsFlowWrapper {
    
    interface Post : FlowWrapper.Post<PaymentsUiState>
    interface Collect : FlowWrapper.Collect<PaymentsUiState>
    interface Mutable : FlowWrapper.Mutable<PaymentsUiState>, Post, Collect
    class Base : FlowWrapper.Base<PaymentsUiState>(PaymentsUiState.Initial()), Mutable
}