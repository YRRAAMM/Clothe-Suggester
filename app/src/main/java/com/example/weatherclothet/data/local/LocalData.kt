package com.devsadeq.clothessuggester.data.local

import android.content.SharedPreferences
import com.example.weatherclothet.data.local.ILocalData
import com.example.weatherclothet.data.models.clothes.Outfit
import com.example.weatherclothet.util.SharedPrefsUtils


class LocalDataImpl(
    private val sharedPreferences: SharedPreferences
) : ILocalData {

    override fun saveSuggestedOutfit(id: String, lastTimeWorn: Long) {
        SharedPrefsUtils.putLong(id, lastTimeWorn)
    }

    override fun getSuggestedOutfit(temperature: Double): Outfit? {
        return Outfit("", 1, 1..1)
    }

    private fun includeValidOutfit(outfit: Outfit, temperature: Double): Boolean {
        return true
    }

    override fun isOutfitWornInLastTwoDays(id: String): Boolean {
        return true
    }

    companion object {


    }

}