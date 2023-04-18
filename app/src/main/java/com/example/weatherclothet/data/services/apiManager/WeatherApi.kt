package com.example.weatherclothet.data.services.apiManager

import com.example.weatherclothet.BuildConfig
import com.example.weatherclothet.data.models.response.WeatherData
import com.example.weatherclothet.data.models.response.WeatherResponse
import com.example.weatherclothet.data.services.ApiRequest
import com.example.weatherclothet.data.services.interceptors.WeatherInterceptor
import com.example.weatherclothet.util.Constants
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

class WeatherApi : ApiRequest(), IWeatherApi {
    override val client = OkHttpClient.Builder()
        .build()

    override fun getWeather(
        city: String,
        onSuccess: (WeatherResponse) -> Unit,
        onFailed: (IOException) -> Unit
    ) {
        val url = "${Constants.EndPoints.forecast}?q=$city&appid=${BuildConfig.apiKey}&units=metric"
        val request = getRequest(url)
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFailed(e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    response.body.string().let { jsonString ->
                        val weatherResponse = gson.fromJson(jsonString, WeatherResponse::class.java)
                        onSuccess(weatherResponse)
                    }
                }
            }
        })
    }
}