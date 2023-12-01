package com.zhigaras.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class NavigationImpl(@IdRes private val container: Int) : Navigation {
    
    private lateinit var fragmentManager: FragmentManager
    
    override fun setUpNavigation(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }
    
    override fun goTo(fragment: Class<out BaseFragment<*>>, args: Bundle?) {
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .commit()
    }
    
    override fun goAndAddToBackStack(fragment: Class<out BaseFragment<*>>, args: Bundle?) {
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .addToBackStack(fragment.simpleName)
            .commit()
    }
    
    override fun goToStart() {
        if (fragmentManager.backStackEntryCount > 0) {
            val first = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}