package com.example.weatherclothet.data.models.response

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("day")
    val day: Double,

    @SerializedName("night")
    val night: Double
)
