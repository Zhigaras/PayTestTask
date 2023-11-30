package com.zhigaras.login.domain

import android.view.View
import android.widget.Toast
import com.zhigaras.core.UiState
import com.zhigaras.login.databinding.FragmentLoginBinding

interface LoginUiState : UiState<FragmentLoginBinding> {
    
    class Initial : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = Unit
    }
    
    class Loading : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = with(binding) {
            progressBar.root.visibility = View.VISIBLE
        }
    }
    
    class Success : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = with(binding) {
            progressBar.root.visibility = View.GONE
        }
    }
    
    class Error(private val message: String) : UiState.SingleEvent<FragmentLoginBinding>(),
        LoginUiState {
        
        override val block: FragmentLoginBinding.() -> Unit = {
            progressBar.root.visibility = View.GONE
            Toast.makeText(root.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}