package com.example.myweatherapp.di

import com.example.myweatherapp.data.mapper.WeatherMapper
import com.example.myweatherapp.data.repository.LocationRepositoryImpl
import com.example.myweatherapp.data.repository.WeatherRepositoryImpl
import com.example.myweatherapp.domain.repository.LocationRepository
import com.example.myweatherapp.domain.repository.WeatherRepository
import com.example.myweatherapp.domain.usecase.GetCurrentLocationUseCase
import com.example.myweatherapp.domain.usecase.GetCurrentWeatherUseCase
import com.example.myweatherapp.presentation.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }
    single<LocationRepository> {
        LocationRepositoryImpl(
            fusedLocationProviderClient = get(),
            context = androidContext()
        )
    }
    single<WeatherRepository> {
        WeatherRepositoryImpl(
            weatherMapper = get()
        )
    }
    single { WeatherMapper() }
    single { com.example.myweatherapp.presentation.viewmodel.mapper.WeatherMapper() }
    single { GetCurrentLocationUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
    viewModel {
        WeatherViewModel(
            getCurrentWeatherUseCase = get(),
            getCurrentLocationUseCase = get(),
            weatherMapper = get(),
            context = androidContext()
        )
    }
}