package com.zhigaras.paytesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhigaras.core.NavigationImpl
import com.zhigaras.login.ui.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val navigation = NavigationImpl(supportFragmentManager, R.id.container)
        
        if (savedInstanceState == null)
            navigation.goTo(LoginFragment::class.java)
    }
}