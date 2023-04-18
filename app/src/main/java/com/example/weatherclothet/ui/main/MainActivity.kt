package com.example.weatherclothet.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.commit
import com.example.weatherclothet.R
import com.example.weatherclothet.databinding.ActivityMainBinding
import com.example.weatherclothet.presenter.mainPresenter.IMainContract
import com.example.weatherclothet.presenter.mainPresenter.MainPresenter
import com.example.weatherclothet.ui.base.BaseActivity
import com.example.weatherclothet.ui.home.HomeFragment



class MainActivity : BaseActivity<ActivityMainBinding>(), IMainContract.IView {

    override val bindingInflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private val presenter: IMainContract.IPresenter by lazy {
        MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Call presenter's onMain() method to trigger navigation
        presenter.onMain()
    }

    override fun navigateToHomeScreen() {
        // Navigate to HomeFragment or perform any other navigation logic
        supportFragmentManager.commit {
            replace(
                R.id.fragment_home_container,
                HomeFragment(),
                HomeFragment::class.java.name
            )
            setReorderingAllowed(true)
        }
    }
}
