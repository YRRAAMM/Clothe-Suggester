package com.example.weatherclothet.data.services

import com.example.weatherclothet.util.Constants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

abstract class ApiRequest {
    val gson = Gson()

    protected abstract val client: OkHttpClient

    private fun makeRequest(endPoint: String): Request.Builder {
        return Request.Builder()
            .url("${Constants.URL}/$endPoint")
    }

    open fun getRequest(endPoint: String): Request = makeRequest(endPoint).get().build()

}