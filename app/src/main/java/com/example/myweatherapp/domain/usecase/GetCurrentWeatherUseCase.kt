package com.example.myweatherapp.domain.usecase

import com.example.myweatherapp.domain.model.Weather
import com.example.myweatherapp.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(lat: Double, long: Double): Weather{
        return weatherRepository.getWeatherByCoordinate(lat, long)
    }
}