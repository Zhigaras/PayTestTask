package com.zhigaras.payments.ui

import androidx.viewbinding.ViewBinding
import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.payments.domain.PaymentDomain
import com.zhigaras.payments.databinding.BasePaymentItemBinding
import com.zhigaras.payments.databinding.DateDividerItemBinding

interface PaymentUi<VB : ViewBinding> : ListItem {
    
    fun bind(binding: VB)
    
    override fun itemType() = this::class.hashCode()
    
    class Base(private val payment: PaymentDomain) : PaymentUi<BasePaymentItemBinding> {
        override fun areItemTheSame(other: ListItem): Boolean {
            if (other !is Base) return false
            return payment.areItemsTheSame(other.payment)
        }
        
        override fun areContentTheSame(other: ListItem): Boolean {
            return areItemTheSame(other)
        }
        
        override fun bind(binding: BasePaymentItemBinding) {
            payment.bind(binding)
        }
    }
    
    class Divider(private val day: String) : PaymentUi<DateDividerItemBinding> {
        override fun areItemTheSame(other: ListItem): Boolean {
            if (other !is Divider) return false
            return day == other.day
        }
        
        override fun areContentTheSame(other: ListItem): Boolean {
            return areItemTheSame(other)
        }
        
        override fun bind(binding: DateDividerItemBinding) = with(binding) {
            root.text = day
        }
    }
}