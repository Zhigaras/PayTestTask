package com.zhigaras.core

import android.os.Bundle
import androidx.fragment.app.FragmentManager

interface Navigation {
    
    fun setUpNavigation(fragmentManager: FragmentManager)
    
    fun goTo(fragment: Class<out BaseFragment<*>>, args: Bundle? = null)
    
    fun goAndAddToBackStack(fragment: Class<out BaseFragment<*>>, args: Bundle? = null)
    
    fun goToStart()
}