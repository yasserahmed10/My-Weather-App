package com.example.myweatherapp.domain.usecase


import com.example.myweatherapp.domain.model.Location
import com.example.myweatherapp.domain.repository.LocationRepository

class GetCurrentLocationUseCase(
    val locationRepository: LocationRepository
) {
    suspend operator fun invoke(): Location{
        return locationRepository.getLocation()
    }
}