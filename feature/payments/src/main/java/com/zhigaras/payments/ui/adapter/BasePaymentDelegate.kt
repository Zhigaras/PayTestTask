package com.zhigaras.payments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.AdapterDelegate
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.payments.databinding.BasePaymentItemBinding
import com.zhigaras.payments.ui.PaymentUi

class BasePaymentDelegate : AdapterDelegate<PaymentUi.Base, BasePaymentViewHolder>() {
    
    override fun viewType() = PaymentUi.Base::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = BasePaymentViewHolder(
        BasePaymentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

class BasePaymentViewHolder(
    private val binding: BasePaymentItemBinding
) : DelegateViewHolder<PaymentUi.Base>(binding) {
    override fun bind(item: PaymentUi.Base) {
        item.bind(binding)
    }
}