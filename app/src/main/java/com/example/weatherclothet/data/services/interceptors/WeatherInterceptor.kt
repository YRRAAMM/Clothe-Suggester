package com.example.weatherclothet.data.services.interceptors

import com.example.weatherclothet.BuildConfig
import com.example.weatherclothet.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

class WeatherInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header(Constants.AUTH, "${Constants.BEARER} ${BuildConfig.apiKey}").build()
        return chain.proceed(request)
    }
}