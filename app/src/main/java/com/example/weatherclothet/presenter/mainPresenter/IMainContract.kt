package com.example.weatherclothet.presenter.mainPresenter

interface IMainContract {
    interface IView {
        fun navigateToHomeScreen()
    }

    interface IPresenter {
        fun onMain()
    }
}