package com.example.myweatherapp.domain.repository

import com.example.myweatherapp.domain.model.Location

interface LocationRepository {
    suspend fun getLocation(): Location
}