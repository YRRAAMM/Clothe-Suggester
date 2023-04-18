package com.example.weatherclothet.util
//https://api.openweathermap.org/data/2.5/forecast/daily?q=egypt&appid=ed60fcfbd110ee65c7150605ea8aceea&units=metric
object Constants {
    const val URL = "https://api.openweathermap.org/data/2.5"
    const val IMG_URL = "https://openweathermap.org/img/wn"
    const val AUTH = "Authorization"
    const val BEARER = "Bearer"
    object EndPoints {
        const val weather = "weather"
        const val forecast = "forecast/daily"
    }
}