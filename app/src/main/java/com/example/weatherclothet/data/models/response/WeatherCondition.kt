package com.example.weatherclothet.data.models.response

import com.google.gson.annotations.SerializedName

data class WeatherCondition(
    @SerializedName("main")
    val main: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("icon")
    val icon: String
)
