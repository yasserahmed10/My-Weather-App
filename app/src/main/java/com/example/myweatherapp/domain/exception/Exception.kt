package com.example.myweatherapp.domain.exception

open class DomainExceptions(message: String) : Exception(message)

class NoWeatherFoundException : DomainExceptions("No weather found")