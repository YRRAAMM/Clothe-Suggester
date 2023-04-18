package com.example.weatherclothet.presenter.homePresenter

import com.example.weatherclothet.data.services.apiManager.IWeatherApi

class HomePresenter(
    private val view: IHomeContract.IView,
    private val weatherApi: IWeatherApi
) : IHomeContract.IPresenter {

    override fun fetchWeatherData(city: String) {
        // Call the API to fetch weather data
        weatherApi.getWeather(
            city = city,
            onSuccess = { weatherData ->
                // Update UI with weather data
                view.showWeatherData(weatherData)
            },
            onFailed = { exception ->
                // Show error message
                view.showError(exception.localizedMessage)
            }
        )
    }
}