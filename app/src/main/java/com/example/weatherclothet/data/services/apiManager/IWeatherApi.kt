package com.example.weatherclothet.data.services.apiManager

import com.example.weatherclothet.data.models.response.WeatherData
import com.example.weatherclothet.data.models.response.WeatherResponse
import java.io.IOException

interface IWeatherApi {
    fun getWeather(
        city: String,
        onSuccess: (WeatherResponse) -> Unit,
        onFailed: (IOException) -> Unit
    )
}