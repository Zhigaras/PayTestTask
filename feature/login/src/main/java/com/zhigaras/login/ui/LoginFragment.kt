package com.zhigaras.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.zhigaras.core.BaseFragment
import com.zhigaras.login.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentLoginBinding.inflate(inflater)
    
    private val viewModel by viewModel<LoginViewModel>()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }
}