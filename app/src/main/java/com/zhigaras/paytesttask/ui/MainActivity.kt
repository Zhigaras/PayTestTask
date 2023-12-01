package com.zhigaras.paytesttask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhigaras.paytesttask.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val viewModel by viewModel<MainViewModel>()
        
        viewModel.init(savedInstanceState == null, supportFragmentManager)
    }
}