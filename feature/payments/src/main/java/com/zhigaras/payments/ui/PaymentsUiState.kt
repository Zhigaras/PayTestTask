package com.zhigaras.payments.ui

import com.zhigaras.adapterdelegate.CompositeAdapter
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
    
    class Success(private val list: List<PaymentUi<*>>) : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) {
            (binding.recyclerView.adapter as CompositeAdapter).submitList(list)
        }
    }
    
    class Error(private val message: String) : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) {
        
        }
    }
}