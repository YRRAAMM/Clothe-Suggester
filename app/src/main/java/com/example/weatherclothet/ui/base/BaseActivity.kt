package com.example.weatherclothet.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {
    lateinit var binding: VB
    abstract val bindingInflate: (LayoutInflater) -> VB


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = bindingInflate(layoutInflater)
        setContentView(binding.root)
    }
}