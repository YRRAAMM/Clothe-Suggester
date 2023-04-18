package com.example.weatherclothet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherclothet.BuildConfig
import com.example.weatherclothet.data.models.response.WeatherData
import com.example.weatherclothet.databinding.FragmentHomeBinding
import com.example.weatherclothet.presenter.homePresenter.HomePresenter
import com.example.weatherclothet.presenter.homePresenter.IHomeContract
import com.example.weatherclothet.ui.base.BaseFragment
import com.example.weatherclothet.util.showToast
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HomeFragment : BaseFragment<FragmentHomeBinding, HomePresenter>(), IHomeContract.IView {
    override val bindingInflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    override val presenter: HomePresenter
        get() = HomePresenter(this)

    private lateinit var gson: Gson
    private lateinit var okHttpClient: OkHttpClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Gson and OkHttpClient
        gson = Gson()
        okHttpClient = OkHttpClient()

        // Fetch weather data
        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        val apiKey = BuildConfig.apiKey // Replace with your OpenWeatherMap API key
        val apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=Egypt&appid=$apiKey"

        val request = Request.Builder()
            .url(apiUrl)
            .build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onResponse(call: okhttp3.Call, response: Response) {
                try {
                    val body = response.body.string()
                    val weatherData = gson.fromJson(body, WeatherData::class.java)

                    // Access temperature data from weatherData object
                    val temperature = weatherData?.main?.temp

                    // Update UI on the main thread
                    activity?.runOnUiThread {
                        // Display temperature in your UI
                        // For example, update a TextView
                        // textView.text = "Temperature: $temperature"
                        showToast(temperature.toString())
//                        binding.temp.text = temperature.toString()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: okhttp3.Call, e: IOException) {
                e.printStackTrace()
            }
        })
    }

}