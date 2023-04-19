package com.example.weatherclothet.data.local

import com.example.weatherclothet.data.models.clothes.Outfit

interface ILocalData {
    fun saveSuggestedOutfit(id: String, lastTimeWorn: Long)

    fun getSuggestedOutfit(temperature: Double): Outfit?

    fun isOutfitWornInLastTwoDays(id: String): Boolean
}