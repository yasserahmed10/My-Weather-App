package com.example.myweatherapp.domain.model

data class Weather (
    val currentTemperature: Int,
    val currentWeatherForecast: WeatherForecast,
    val minTemperature: Int,
    val maxTemperature: Int,
    val wind: Int,
    val humidity: Int,
    val rain: Int,
    val uvIndex: Int,
    val pressure: Int,
    val feelsLike: Int,
    val hourlyWeather: List<HourlyWeather>,
    val weeklyWeather: List<DailyWeather>,
    val isDay: Boolean
)