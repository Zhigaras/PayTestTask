package com.zhigaras.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface StartNavigation {
    
    fun setUpNavigation(fragmentManager: FragmentManager, @IdRes container: Int)
    
    fun goToLogin(args: Bundle? = null)
    
    fun goToPayments(args: Bundle? = null)
}