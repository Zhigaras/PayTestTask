package com.zhigaras.login.domain

import android.os.Bundle

interface LoginNavigation {
    
    fun fromLoginToPayments(args: Bundle? = null)
}