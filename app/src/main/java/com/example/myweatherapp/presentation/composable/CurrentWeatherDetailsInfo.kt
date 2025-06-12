package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.example.myweatherapp.ui.theme.ThemeColor

@Composable
fun CurrentWeatherDetailsInfo(
    theme: ThemeColor,
    wind: Int = 13,
    humidity: Int = 24,
    rain: Int = 2,
    uv_index: Int = 2,
    pressure: Int = 1012,
    feelsLike: Int = 22,
){
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ){
            WeatherDetailsInfoItem(
                theme,
                icon = painterResource(R.drawable.wind),
                value = "$wind KM/h",
                name = "Wind"
            )
            WeatherDetailsInfoItem(
                theme,
                icon = painterResource(R.drawable.humidity),
                value = "$humidity%",
                name = "Humidity"
            )
            WeatherDetailsInfoItem(
                theme,
                icon = painterResource(R.drawable.rain),
                value = "$rain%",
                name = "Rain"
            )
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ){
            WeatherDetailsInfoItem(
                theme,
                icon = painterResource(R.drawable.uv_index),
                value = uv_index.toString(),
                name = "UV Index"
            )
            WeatherDetailsInfoItem(
                theme,
                icon = painterResource(R.drawable.pressure),
                value = "$pressure hPa",
                name = "Pressure"
            )
            WeatherDetailsInfoItem(
                theme,
                icon = painterResource(R.drawable.feels_like),
                value = "$feelsLike°C",
                name = "Feels like"
            )
        }
    }
}