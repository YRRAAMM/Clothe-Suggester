package com.example.weatherclothet.util

import android.content.Context
import android.content.SharedPreferences

object SharedPrefsUtils {
    private var sharedPreferences: SharedPreferences? = null
    private const val SHARED_PREF = "ClothPrefs"
    private val KEY = "clothes"

    fun initPrefUtil(context: Context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    }

    fun putLong(id: String, lastTimeWorn: Long) {
        sharedPreferences?.edit()?.putLong(id, lastTimeWorn)?.apply()

    }

    fun getLong(id: String, i: Int): Long {
        return sharedPreferences?.getLong(id, 0) ?: 0
    }

    var clothName: String?
        get() = sharedPreferences?.getString(KEY,null)
        set(value) {
            sharedPreferences?.edit()?.putString(KEY,value)?.apply()
        }
}