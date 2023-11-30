package com.zhigaras.login.domain

import com.zhigaras.core.UiState
import com.zhigaras.login.databinding.FragmentLoginBinding

interface LoginUiState : UiState<FragmentLoginBinding> {
    
    class Initial : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = Unit
    }
    
    class Loading : LoginUiState {
        override fun update(binding: FragmentLoginBinding) {
        
        }
    }
    
    class Success : LoginUiState {
        override fun update(binding: FragmentLoginBinding) {
        
        }
    }
    
    class Error(private val message: String) : LoginUiState {
        override fun update(binding: FragmentLoginBinding) {
        
        }
    }
}