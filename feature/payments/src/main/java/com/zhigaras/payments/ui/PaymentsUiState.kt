package com.zhigaras.payments.ui

import com.zhigaras.core.UiState
import com.zhigaras.payments.databinding.FragmentPaymentsBinding

interface PaymentsUiState : UiState<FragmentPaymentsBinding> {
    
    class Initial : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) = Unit
    }
    
    class Loading : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) {
        
        }
    }
    
    class Success : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) {
        
        }
    }
    
    class Error : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) {
        
        }
    }
}