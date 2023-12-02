package com.zhigaras.core

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

abstract class AbstractInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr), InputValidation {
    
    protected abstract val errorMessageId: Int
    
    protected abstract fun innerIsValid(): Boolean
    
    override fun text(): String = (editText?.text ?: "").toString()
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        editText?.doOnTextChanged { _, _, _, _ -> error = "" }
    }
    
    override fun isValid(): Boolean {
        val isValid = innerIsValid()
        error = if (isValid) "" else context.getString(errorMessageId)
        return isValid
    }
    
    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle().also {
            it.putParcelable("state", super.onSaveInstanceState())
            it.putString("text", editText!!.text.toString())
        }
        return bundle
    }
    
    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            editText!!.setText(state.getString("text"))
            super.onRestoreInstanceState(state.getParcelable("state"))
        } else {
            super.onRestoreInstanceState(state)
        }
    }
}

interface InputValidation {
    
    fun isValid(): Boolean
    
    fun text(): String
}