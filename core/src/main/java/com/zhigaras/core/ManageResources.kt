package com.zhigaras.core

import android.content.Context
import androidx.annotation.StringRes

interface ManageResources {
    
    fun getString(@StringRes id: Int): String
    
    class Base(private val context: Context) : ManageResources {
        
        override fun getString(id: Int) = context.getString(id)
    }
}