package com.example.myweatherapp.domain.model

data class HourlyWeather(
    val temperature: Int,
    val weatherForecast: WeatherForecast,
    val hour: Int
)