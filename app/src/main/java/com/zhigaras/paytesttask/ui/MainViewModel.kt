package com.zhigaras.paytesttask.ui

import androidx.fragment.app.FragmentManager
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.login.ui.LoginFragment
import com.zhigaras.payments.ui.PaymentsFragment
import com.zhigaras.paytesttask.domain.MainFlowWrapper
import com.zhigaras.tokenstorage.TokenStorage

class MainViewModel(
    private val navigation: Navigation,
    private val tokenStorage: TokenStorage,
    override val flowWrapper: MainFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<MainUiState>(dispatchers) {
    
    fun init(isFirstRun: Boolean, fragmentManager: FragmentManager) {
        navigation.setUpNavigation(fragmentManager)
        if (isFirstRun) {
            if (tokenStorage.isLoggedIn()) navigation.goTo(PaymentsFragment::class.java)
            else navigation.goTo(LoginFragment::class.java)
        }
    }
}