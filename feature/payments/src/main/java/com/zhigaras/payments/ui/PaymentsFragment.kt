package com.zhigaras.payments.ui

import android.view.LayoutInflater
import com.zhigaras.core.BaseFragment
import com.zhigaras.payments.databinding.FragmentPaymentsBinding

class PaymentsFragment : BaseFragment<FragmentPaymentsBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentPaymentsBinding.inflate(inflater)
}