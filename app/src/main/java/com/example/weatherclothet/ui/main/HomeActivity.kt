package com.example.weatherclothet.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import com.example.weatherclothet.R
import com.example.weatherclothet.databinding.ActivityHomeBinding
import com.example.weatherclothet.ui.base.BaseActivity


class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override val bindingInflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}