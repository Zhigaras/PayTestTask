package com.zhigaras.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class NavigationImpl(
    private val fragmentManager: FragmentManager,
    @IdRes private val container: Int
) : Navigation {
    
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