package com.zhigaras.core

import android.os.Bundle

interface Navigation {
    
    fun goTo(fragment: Class<out BaseFragment<*>>, args: Bundle? = null)
    
    fun goAndAddToBackStack(fragment: Class<out BaseFragment<*>>, args: Bundle? = null)
    
    fun goToStart()
}