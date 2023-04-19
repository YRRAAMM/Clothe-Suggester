package com.tahaproject.todoy_app.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response


class TodoInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }

}