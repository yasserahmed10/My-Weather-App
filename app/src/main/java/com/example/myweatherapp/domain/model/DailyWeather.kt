package com.example.myweatherapp.domain.model

data class DailyWeather(
    val weatherForecast: WeatherForecast,
    val maxTemperature: Int,
    val minTemperature: Int,
    val day: Day
)