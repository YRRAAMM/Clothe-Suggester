package com.example.weatherclothet.data.models.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list")
    val list: List<WeatherData>
)