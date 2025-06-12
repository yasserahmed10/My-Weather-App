package com.example.myweatherapp.presentation.viewmodel.state

import com.android.myweather.R

data class TodayForecastUiState(
    val temperature: Int = 0,
    val forecast: String = "",
    val forecastImg: Int = R.drawable.fog_day,
    val minTemp: Int = 0,
    val maxTemp: Int = 0,
    val wind: Int = 0,
    val humidity: Int = 0,
    val rain: Int = 0,
    val uvIndex: Int = 0,
    val pressure: Int = 0,
    val feelLike: Int = 0,
)