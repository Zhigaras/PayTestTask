package com.zhigaras.payments.domain

import android.os.Bundle

interface PaymentsNavigation {
    
    fun fromPaymentsToLogin(args: Bundle? = null)
}