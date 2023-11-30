package com.zhigaras.paytesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhigaras.core.Navigation
import com.zhigaras.login.ui.LoginFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val navigation by inject<Navigation>()
        
        if (savedInstanceState == null)
            navigation.goTo(supportFragmentManager, LoginFragment::class.java)
    }
}