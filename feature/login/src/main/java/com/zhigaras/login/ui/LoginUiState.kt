package com.zhigaras.login.ui

import android.view.View
import androidx.core.animation.doOnEnd
import com.google.android.material.snackbar.Snackbar
import com.zhigaras.core.UiState
import com.zhigaras.login.databinding.FragmentLoginBinding
import com.zhigaras.payments.R

interface LoginUiState : UiState<FragmentLoginBinding> {
    
    class Initial : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = Unit
    }
    
    class Loading : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = with(binding) {
            progressBar.root.visibility = View.VISIBLE
        }
    }
    
    class Success(private val navigate: () -> Unit) : LoginUiState {
        override fun update(binding: FragmentLoginBinding) = with(binding) {
            progressBar.root.visibility = View.GONE
            payload.visibility = View.GONE
            greetingView.root.visibility = View.VISIBLE
            greetingView.root.addAnimatorUpdateListener { it.doOnEnd { navigate.invoke() } }
        }
    }
    
    class Error(private val message: String) : UiState.SingleEvent<FragmentLoginBinding>(),
        LoginUiState {
        
        override val block: FragmentLoginBinding.() -> Unit = {
            progressBar.root.visibility = View.GONE
            Snackbar.make(root, message, Snackbar.LENGTH_INDEFINITE).apply {
                setAction(root.context.getString(R.string.close)) { dismiss() }
                show()
            }
        }
    }
}