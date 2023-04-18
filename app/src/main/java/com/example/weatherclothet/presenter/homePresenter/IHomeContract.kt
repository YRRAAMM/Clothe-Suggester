package com.example.weatherclothet.presenter.homePresenter

import com.example.weatherclothet.data.models.response.WeatherData

interface IHomeContract {
    interface IView {
        fun showWeatherData(weatherData: WeatherData)
        fun showError(errorMessage: String)
    }

    interface IPresenter {
        fun fetchWeatherData(city: String)
    }
}