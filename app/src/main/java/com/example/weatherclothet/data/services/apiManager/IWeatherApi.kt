package com.example.weatherclothet.data.services.apiManager

import com.example.weatherclothet.data.models.response.WeatherData
import java.io.IOException

interface IWeatherApi {
    fun getWeather(
        city: String,
        onSuccess: (WeatherData) -> Unit,
        onFailed: (IOException) -> Unit
    )
}