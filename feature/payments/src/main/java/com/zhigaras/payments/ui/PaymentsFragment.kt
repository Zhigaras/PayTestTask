package com.zhigaras.payments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.core.BaseFragment
import com.zhigaras.payments.databinding.FragmentPaymentsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentsFragment : BaseFragment<FragmentPaymentsBinding>() {
    
    private val viewModel by viewModel<PaymentsViewModel>()
    
    override fun initBinding(inflater: LayoutInflater) = FragmentPaymentsBinding.inflate(inflater)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.logoutButton.setOnClickListener { viewModel.loadPayments() }
    }
}