package com.zhigaras.login.domain

import com.zhigaras.core.UiState
import com.zhigaras.login.databinding.FragmentLoginBinding

interface LoginUiState : UiState<FragmentLoginBinding> {
    
    class Initial : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = Unit
    }
}