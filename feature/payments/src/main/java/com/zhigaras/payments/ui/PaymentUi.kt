package com.zhigaras.payments.ui

import com.zhigaras.cloudservice.model.PaymentDomain

interface PaymentUi {
    
    class Base(private val payment: PaymentDomain) : PaymentUi
    
    class Divider(private val day: String) : PaymentUi
}