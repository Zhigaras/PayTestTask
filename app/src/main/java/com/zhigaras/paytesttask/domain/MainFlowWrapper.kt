package com.zhigaras.paytesttask.domain

import com.zhigaras.core.FlowWrapper
import com.zhigaras.paytesttask.ui.MainUiState

interface MainFlowWrapper {
    
    interface Post : FlowWrapper.Post<MainUiState>
    interface Collect : FlowWrapper.Collect<MainUiState>
    interface Mutable : FlowWrapper.Mutable<MainUiState>, Post, Collect
    class Base : FlowWrapper.Base<MainUiState>(MainUiState.Initial()), Mutable
}