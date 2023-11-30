package com.zhigaras.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<T : UiState<*>>(
    private val dispatchers: Dispatchers,
) : ViewModel(), FlowWrapper.Collect<T> {
    
    protected abstract val flowWrapper: FlowWrapper.Mutable<T>
    
    override suspend fun collect(collector: FlowCollector<T>) {
        flowWrapper.collect(collector)
    }
    
    protected fun <E> scopeLaunch(
        onBackground: suspend () -> E,
        onUi: suspend (E) -> Unit
    ) = viewModelScope.launch(dispatchers.io()) {
        val result = onBackground.invoke()
        withContext(dispatchers.main()) {
            onUi.invoke(result)
        }
    }
}