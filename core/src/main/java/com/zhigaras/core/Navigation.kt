package com.zhigaras.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface Navigation {
    
    fun setUpNavigation(fragmentManager: FragmentManager, @IdRes container: Int)
    
    fun goTo(fragment: Class<out BaseFragment<*>>, args: Bundle? = null)
    
    fun goAndAddToBackStack(fragment: Class<out BaseFragment<*>>, args: Bundle? = null)
    
    fun goToStart()
}