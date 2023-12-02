package com.zhigaras.payments.ui

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.core.UiState
import com.zhigaras.core.formatPrice
import com.zhigaras.payments.R
import com.zhigaras.payments.databinding.FragmentPaymentsBinding

interface PaymentsUiState : UiState<FragmentPaymentsBinding> {
    
    class Initial : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) = Unit
    }
    
    class Loading : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) = with(binding) {
            progressBar.root.visibility = View.VISIBLE
        }
    }
    
    class Success(
        private val list: List<PaymentUi<*>>,
        private val totalAmount: Double
    ) : PaymentsUiState {
        override fun update(binding: FragmentPaymentsBinding) = with(binding) {
            (recyclerView.adapter as CompositeAdapter).submitList(list)
            totalAmountTextView.text =
                root.context.getString(R.string.payment_amount, totalAmount.formatPrice())
            payload.visibility = View.VISIBLE
            progressBar.root.visibility = View.GONE
        }
    }
    
    class Error(private val message: String) : UiState.SingleEvent<FragmentPaymentsBinding>(),
        PaymentsUiState {
        
        override val block: FragmentPaymentsBinding.() -> Unit = {
            progressBar.root.visibility = View.GONE
            Snackbar.make(root, message, Snackbar.LENGTH_INDEFINITE).apply {
                setAction(root.context.getString(R.string.close)) { dismiss() }
                show()
            }
        }
    }
}