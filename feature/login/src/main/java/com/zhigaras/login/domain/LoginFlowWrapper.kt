package com.zhigaras.login.domain

import com.zhigaras.core.FlowWrapper
import com.zhigaras.login.ui.LoginUiState

interface LoginFlowWrapper {
    
    interface Post : FlowWrapper.Post<LoginUiState>
    interface Collect : FlowWrapper.Collect<LoginUiState>
    interface Mutable : FlowWrapper.Mutable<LoginUiState>, Post, Collect
    class Base : FlowWrapper.Base<LoginUiState>(LoginUiState.Initial()), Mutable
}