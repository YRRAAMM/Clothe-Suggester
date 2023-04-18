package com.example.weatherclothet.presenter.homePresenter

import com.example.weatherclothet.data.models.response.WeatherResponse
import java.io.IOException

interface IHomeContract {
    interface IView {
        fun showWeatherData(weatherResponse: WeatherResponse)
        fun showError(error: IOException)
    }

    interface IPresenter {
        fun fetchWeatherData(city: String)
    }
}