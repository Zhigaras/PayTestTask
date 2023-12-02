package com.zhigaras.paytesttask.ui

import androidx.fragment.app.FragmentManager
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.navigation.StartNavigation
import com.zhigaras.paytesttask.R
import com.zhigaras.paytesttask.domain.MainFlowWrapper
import com.zhigaras.tokenstorage.TokenStorage

class MainViewModel(
    private val navigation: StartNavigation,
    private val tokenStorage: TokenStorage,
    override val flowWrapper: MainFlowWrapper.Mutable,
    dispatchers: Dispatchers
) : BaseViewModel<MainUiState>(dispatchers) {
    
    fun init(isFirstRun: Boolean, fragmentManager: FragmentManager) {
        navigation.setUpNavigation(fragmentManager, R.id.container)
        if (isFirstRun) {
            if (tokenStorage.isLoggedIn()) navigation.goToPayments()
            else navigation.goToLogin()
        }
    }
}