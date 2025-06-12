package com.example.myweatherapp.presentation.viewmodel

import android.Manifest
import android.content.Context
import android.location.LocationManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.domain.usecase.GetCurrentLocationUseCase
import com.example.myweatherapp.domain.usecase.GetCurrentWeatherUseCase
import com.example.myweatherapp.presentation.viewmodel.mapper.WeatherMapper
import com.example.myweatherapp.presentation.viewmodel.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    val weatherMapper: WeatherMapper,
    val context: Context,
):ViewModel(){

    private val _cityName = MutableStateFlow("")
    val cityName: StateFlow<String> = _cityName.asStateFlow()

    private val _weatherUiData = MutableStateFlow(WeatherUiState())
    val weatherUiData: StateFlow<WeatherUiState> = _weatherUiData.asStateFlow()

    private val _isDay = MutableStateFlow(true)
    val isDay: StateFlow<Boolean> = _isDay.asStateFlow()

    fun getCurrentLocation() {
        if (!isLocationEnabled()) {
            return
        }
        viewModelScope.launch {
            try {
                val location = getCurrentLocationUseCase()
                val weather = getCurrentWeatherUseCase(location.latitude, location.longitude)
                _weatherUiData.value = weatherMapper.mapWeatherToWeatherUiState(weather)
                _cityName.value = location.city
                _isDay.value = weather.isDay
            } catch (e: Exception) {

            }
        }
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    fun checkPermission(): Boolean {
        return context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED &&
                context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }
}