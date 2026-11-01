package com.example.shalatku

data class Prayer(val name: String, val time: String)

val samplePrayers = listOf(
    Prayer("Subuh", "04:35"),
    Prayer("dhuha", "09:10"),
    Prayer("Dzuhur", "11:50"),
    Prayer("Ashar", "15:10"),
    Prayer("Maghrib", "17:55"),
    Prayer("Isya", "19:05"),
    Prayer("Taraweh", "20:00"),
    Prayer("Qobliyah", "18:00"),
    Prayer("Adzan", "24:00"),
)