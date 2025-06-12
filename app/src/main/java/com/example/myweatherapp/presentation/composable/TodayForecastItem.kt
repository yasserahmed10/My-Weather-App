package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.example.myweatherapp.presentation.viewmodel.state.HourlyForecastUiState
import com.example.myweatherapp.ui.theme.ThemeColor
import com.example.myweatherapp.ui.theme.letterSpacing25
import com.example.myweatherapp.ui.theme.text16
import com.example.myweatherapp.ui.theme.urbanist

@Composable
fun TodayForeCastItem(
    theme: ThemeColor,
    hourlyForecastUiState: HourlyForecastUiState = HourlyForecastUiState(
        forecastImage = R.drawable.weather_icon,
        temperatureDegree = "25°C",
        hour = "11:00"
    )
){
    Box(
        modifier = Modifier
            .padding(start = 12.dp)
            .width(88.dp)
    ){
        Card(
            colors = CardDefaults.cardColors(containerColor = theme.boxBackgroundwhite70pre),
            modifier = Modifier
                .width(88.dp)
                .padding(top = 12.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(width = 1.dp, color = theme.ButtonsdarkBlue8pre, shape = RoundedCornerShape(20.dp))
        ){}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(hourlyForecastUiState.forecastImage),
                contentDescription = null,
                modifier = Modifier.width(64.dp).height(60.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = hourlyForecastUiState.temperatureDegree,
                color = theme.header2darkBlue87pre,
                fontSize = text16,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = hourlyForecastUiState.hour,
                color = theme.contentDarkBlue60pre,
                fontSize = text16,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )
        }
    }
}