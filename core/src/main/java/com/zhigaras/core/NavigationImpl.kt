package com.zhigaras.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class NavigationImpl(@IdRes private val container: Int) : Navigation {
    
    override fun goTo(
        fragmentManager: FragmentManager,
        fragment: Class<out BaseFragment<*>>,
        args: Bundle?
    ) {
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .commit()
    }
    
    override fun goAndAddToBackStack(
        fragmentManager: FragmentManager,
        fragment: Class<out BaseFragment<*>>,
        args: Bundle?
    ) {
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .addToBackStack(fragment.simpleName)
            .commit()
    }
    
    override fun goToStart(fragmentManager: FragmentManager) {
        if (fragmentManager.backStackEntryCount > 0) {
            val first = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}