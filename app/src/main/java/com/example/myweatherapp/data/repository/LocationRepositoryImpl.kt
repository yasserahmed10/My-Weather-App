package com.example.myweatherapp.data.repository

import android.Manifest
import android.content.Context
import android.location.Geocoder
import androidx.annotation.RequiresPermission
import com.example.myweatherapp.domain.model.Location
import com.example.myweatherapp.domain.repository.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.Locale
import kotlin.coroutines.resume

class LocationRepositoryImpl(
    val fusedLocationProviderClient: FusedLocationProviderClient,
    val context: Context
) : LocationRepository {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getLocation(): Location {
        return suspendCancellableCoroutine { cont ->
            val locationTask = fusedLocationProviderClient.lastLocation

            locationTask.addOnSuccessListener { loc ->
                val city = getCity(loc)
                cont.resume(
                    Location(
                        latitude = loc.latitude,
                        longitude = loc.longitude,
                        city = city
                    )
                )
            }
            locationTask.addOnFailureListener {
                throw Exception()
            }
            locationTask.addOnCanceledListener {
                cont.cancel()
            }
        }
    }

    private fun getCity(location: android.location.Location): String{
        val geocoder = Geocoder(context, Locale.getDefault())
        return try {
            val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
            addresses?.firstOrNull()?.adminArea ?: "Unknown" } catch (e: Exception) { "Unknown" }
    }
}