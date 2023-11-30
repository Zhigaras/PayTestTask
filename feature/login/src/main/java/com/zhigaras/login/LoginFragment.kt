package com.zhigaras.login

import android.view.LayoutInflater
import com.zhigaras.core.BaseFragment
import com.zhigaras.login.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    
    override fun initBinding(inflater: LayoutInflater) = FragmentLoginBinding.inflate(inflater)
}