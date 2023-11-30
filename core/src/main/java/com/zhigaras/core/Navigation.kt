package com.zhigaras.core

import android.os.Bundle
import androidx.fragment.app.FragmentManager

interface Navigation {
    
    fun goTo(
        fragmentManager: FragmentManager,
        fragment: Class<out BaseFragment<*>>,
        args: Bundle? = null
    )
    
    fun goAndAddToBackStack(
        fragmentManager: FragmentManager,
        fragment: Class<out BaseFragment<*>>,
        args: Bundle? = null
    )
    
    fun goToStart(fragmentManager: FragmentManager)
}