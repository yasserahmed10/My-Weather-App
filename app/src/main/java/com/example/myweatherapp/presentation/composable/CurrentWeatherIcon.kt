package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.example.myweatherapp.ui.theme.ThemeColor

@Composable
fun CurrentWeatherIcon(
    theme: ThemeColor,
    modifier: Modifier,
    imageModifier: Modifier = Modifier
        .padding(top = 24.dp, start = 30.dp, bottom = 26.dp)
        .height(200.dp)
        .width(220.21.dp),
    blurModifier: Modifier = Modifier.size(250.dp),
    forecastImage: Int = R.drawable.weather_icon
){
    Box (
        modifier = modifier
    ){
        Box(
            modifier = blurModifier
                .clip(CircleShape)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            theme.BlurBlue32pre,
                            theme.backgroundLightBlue.copy(alpha = 0.09f)
                        ),
                        center = Offset.Unspecified,
                    ),
                    shape = CircleShape
                )
        )
        Image(
            painter = painterResource(forecastImage),
            contentDescription = null,
            modifier = imageModifier
        )
    }
}