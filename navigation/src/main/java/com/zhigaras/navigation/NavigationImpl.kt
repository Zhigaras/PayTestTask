package com.zhigaras.navigation

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.zhigaras.core.BaseFragment
import com.zhigaras.login.ui.LoginFragment
import com.zhigaras.payments.ui.PaymentsFragment
import kotlin.properties.Delegates

class NavigationImpl : Navigation {
    
    private lateinit var fragmentManager: FragmentManager
    private var container by Delegates.notNull<Int>()
    
    override fun setUpNavigation(fragmentManager: FragmentManager, container: Int) {
        this.fragmentManager = fragmentManager
        this.container = container
    }
    
    override fun goToLogin(args: Bundle?) {
        goTo(LoginFragment::class.java, args)
    }
    
    override fun goToPayments(args: Bundle?) {
        goTo(PaymentsFragment::class.java, args)
    }
    
    override fun fromLoginToPayments(args: Bundle?) {
        goTo(PaymentsFragment::class.java, args)
    }
    
    override fun fromPaymentsToLogin(args: Bundle?) {
        goAndClearBackStack(LoginFragment::class.java, args)
    }
    
    private fun goTo(fragment: Class<out BaseFragment<*>>, args: Bundle?) {
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .commit()
    }
    
    private fun goAndClearBackStack(fragment: Class<out BaseFragment<*>>, args: Bundle?) {
        if (fragmentManager.backStackEntryCount > 0) {
            val first = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        fragmentManager.beginTransaction()
            .replace(container, fragment, args)
            .commit()
    }
}