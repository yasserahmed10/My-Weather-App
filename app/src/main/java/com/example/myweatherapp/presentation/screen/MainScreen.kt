package com.example.myweatherapp.presentation.screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.presentation.composable.CurrentLocationInfo
import com.example.myweatherapp.presentation.composable.CurrentWeather
import com.example.myweatherapp.presentation.composable.CurrentWeatherDetailsInfo
import com.example.myweatherapp.presentation.composable.TodayForecast
import com.example.myweatherapp.presentation.composable.WeeklyForecast
import com.example.myweatherapp.presentation.viewmodel.WeatherViewModel
import com.example.myweatherapp.ui.theme.appTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: WeatherViewModel = koinViewModel()){

    val weatherUiState = viewModel.weatherUiData.collectAsState().value
    val cityName = viewModel.cityName.collectAsState().value
    val isDay = viewModel.isDay.collectAsState().value

    val theme = appTheme(isDay)

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.all { it.value }
        if (granted) {
            viewModel.getCurrentLocation()
        }
    }

    LaunchedEffect(Unit) {
        if (viewModel.checkPermission()) {
            viewModel.getCurrentLocation()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    val scrollState = rememberScrollState()
    val isScrolled = scrollState.value > 1

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(theme.backgroundLightBlue, theme.background2)))
            .padding(top = 40.dp)
            .verticalScroll(scrollState)
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.padding(horizontal = 12.dp)
        ){
            CurrentWeather(
                Modifier.padding(top = 76.dp),
                isScrolled,
                theme,
                forecastImg = weatherUiState.todayForecastUiState.forecastImg,
                temperature = weatherUiState.todayForecastUiState.temperature,
                forecast = weatherUiState.todayForecastUiState.forecast,
                minTemp = weatherUiState.todayForecastUiState.minTemp,
                maxTemp = weatherUiState.todayForecastUiState.maxTemp
            )
            CurrentLocationInfo(Modifier.padding(top = 64.dp), cityName, theme)
        }
        CurrentWeatherDetailsInfo(
            theme,
            wind = weatherUiState.todayForecastUiState.wind,
            rain = weatherUiState.todayForecastUiState.rain,
            feelsLike = weatherUiState.todayForecastUiState.feelLike,
            humidity = weatherUiState.todayForecastUiState.humidity,
            pressure = weatherUiState.todayForecastUiState.pressure,
            uv_index = weatherUiState.todayForecastUiState.uvIndex
        )
        TodayForecast(theme, forecastStates = weatherUiState.hourlyForecastUiState)
        WeeklyForecast(theme, forecastStates = weatherUiState.weeklyForecastUiState)
    }
}