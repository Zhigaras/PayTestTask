package com.zhigaras.payments.ui

import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.cloudservice.model.PaymentDomain
import com.zhigaras.payments.databinding.BasePaymentItemBinding

interface PaymentUi : ListItem {
    
    override fun itemType() = this::class.hashCode()
    
    class Base(private val payment: PaymentDomain) : PaymentUi {
        override fun areItemTheSame(other: ListItem): Boolean {
            if (other !is Base) return false
            return payment.areItemsTheSame(other.payment)
        }
        
        override fun areContentTheSame(other: ListItem): Boolean {
            return areItemTheSame(other)
        }
        
        fun bind(binding: BasePaymentItemBinding) = with(binding) {
            // TODO:  
        }
    }
    
    class Divider(private val day: String) : PaymentUi {
        override fun areItemTheSame(other: ListItem): Boolean {
            if (other !is Divider) return false
            return day == other.day
        }
        
        override fun areContentTheSame(other: ListItem): Boolean {
            return areItemTheSame(other)
        }
    }
}