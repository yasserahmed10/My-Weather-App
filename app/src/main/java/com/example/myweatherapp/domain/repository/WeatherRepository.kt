package com.example.myweatherapp.domain.repository

import com.example.myweatherapp.domain.model.Weather

interface WeatherRepository{
    suspend fun getWeatherByCoordinate( lat: Double, long: Double): Weather
}