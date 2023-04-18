package com.example.weatherclothet.presenter.mainPresenter

class MainPresenter(private val view: IMainContract.IView) : IMainContract.IPresenter {
    override fun onMain() {
        view.navigateToHomeScreen()
    }
}