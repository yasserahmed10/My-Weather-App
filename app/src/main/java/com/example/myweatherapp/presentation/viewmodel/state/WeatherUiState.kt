package com.example.myweatherapp.presentation.viewmodel.state

data class WeatherUiState(
    val todayForecastUiState: TodayForecastUiState = TodayForecastUiState(),
    val hourlyForecastUiState: List<HourlyForecastUiState> = listOf(),
    val weeklyForecastUiState: List<WeeklyForecastUiState> = listOf()
)