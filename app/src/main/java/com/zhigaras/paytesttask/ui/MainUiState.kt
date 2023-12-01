package com.zhigaras.paytesttask.ui

import com.zhigaras.core.UiState
import com.zhigaras.paytesttask.databinding.ActivityMainBinding

interface MainUiState : UiState<ActivityMainBinding> {
    
    class Initial : MainUiState {
        override fun update(binding: ActivityMainBinding) = Unit
    }
}