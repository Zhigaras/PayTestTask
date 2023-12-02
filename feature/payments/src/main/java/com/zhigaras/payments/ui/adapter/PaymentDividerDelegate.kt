package com.zhigaras.payments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.AdapterDelegate
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.payments.databinding.DateDividerItemBinding
import com.zhigaras.payments.ui.PaymentUi

class PaymentDividerDelegate : AdapterDelegate<PaymentUi.Divider, PaymentDividerViewHolder>() {
    override fun viewType() = PaymentUi.Divider::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = PaymentDividerViewHolder(
        DateDividerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

class PaymentDividerViewHolder(
    private val binding: DateDividerItemBinding
) : DelegateViewHolder<PaymentUi.Divider>(binding) {
    override fun bind(item: PaymentUi.Divider) {
        item.bind(binding)
    }
}