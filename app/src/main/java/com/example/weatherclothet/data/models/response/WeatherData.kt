package com.example.weatherclothet.data.models.response

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("dt")
    val timestamp: Long,

    @SerializedName("weather")
    val weather: List<WeatherCondition>,

    @SerializedName("temp")
    val temperature: Temperature
)