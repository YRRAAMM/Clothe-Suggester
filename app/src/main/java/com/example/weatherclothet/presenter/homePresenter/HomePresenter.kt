package com.example.weatherclothet.presenter.homePresenter

import android.os.Handler
import android.os.Looper
import com.example.weatherclothet.data.models.response.WeatherResponse
import com.example.weatherclothet.data.services.apiManager.IWeatherApi
import java.io.IOException

class HomePresenter(
    private val view: IHomeContract.IView,
    private val weatherApi: IWeatherApi
) : IHomeContract.IPresenter {

    override fun fetchWeatherData(city: String) {
        view.showLoading()
        weatherApi.getWeather(city = city, ::onRequestSuccess, ::onRequestFailed)
        view.hideLoading()
    }

    private val handler = Handler(Looper.getMainLooper())

    private fun onRequestSuccess(weatherResponse: WeatherResponse) {
        handler.post {
            view.showWeatherData(weatherResponse)
        }
    }

    private fun onRequestFailed(error: IOException) {
        view.showError(error)
        view.hideLoading()
    }
}