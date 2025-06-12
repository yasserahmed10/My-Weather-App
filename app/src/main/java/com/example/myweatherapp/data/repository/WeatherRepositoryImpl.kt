package com.example.myweatherapp.data.repository

import com.example.myweatherapp.data.mapper.WeatherMapper
import com.example.myweatherapp.data.model.WeatherDto
import com.example.myweatherapp.domain.model.Weather
import com.example.myweatherapp.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class WeatherRepositoryImpl(
    val weatherMapper: WeatherMapper
): WeatherRepository {
    override suspend fun getWeatherByCoordinate(lat: Double, long: Double): Weather {
        val response = HttpClient(CIO).get(BASE_WEATHER_URL){
            url {
                parameters.append("latitude", lat.toString())
                parameters.append("longitude", long.toString())
                parameters.append("hourly", "temperature_2m,weather_code")
                parameters.append("current", "temperature_2m,wind_speed_10m,relative_humidity_2m,precipitation_probability,uv_index,pressure_msl,is_day,weather_code,apparent_temperature")
                parameters.append("daily", "temperature_2m_max,temperature_2m_min,weather_code")
                parameters.append("forecast_days", "7")
            }
        }
        val weatherDto = Json.decodeFromString<WeatherDto>(response.bodyAsText())
        return weatherMapper.mapDtoToWeather(weatherDto)
    }
    companion object{
        private const val BASE_WEATHER_URL = "https://api.open-meteo.com/v1/forecast"
    }
}