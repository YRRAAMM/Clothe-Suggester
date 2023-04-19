package com.example.weatherclothet.data.models.clothes

data class Outfit(
    val id: String,
    val imageResource: Int,
    val temperature: IntRange,
)