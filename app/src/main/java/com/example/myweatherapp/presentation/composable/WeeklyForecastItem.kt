package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.example.myweatherapp.presentation.viewmodel.state.WeeklyForecastUiState
import com.example.myweatherapp.ui.theme.ThemeColor
import com.example.myweatherapp.ui.theme.letterSpacing25
import com.example.myweatherapp.ui.theme.text16
import com.example.myweatherapp.ui.theme.urbanist

@Composable
fun WeeklyForecastItem(
    themeColor: ThemeColor,
    weeklyForecastUiState: WeeklyForecastUiState = WeeklyForecastUiState(
        day = "Monday",
        forecastImg = R.drawable.weather_icon,
        minTemp = 20,
        maxTemp = 32
    )
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = weeklyForecastUiState.day,
            color = themeColor.contentDarkBlue60pre,
            fontSize = text16,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W400,
            fontFamily = urbanist,
            modifier = Modifier.width(91.dp).align(Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(weeklyForecastUiState.forecastImg),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.CenterVertically)
        ){
            MinMaxTemperature(painterResource(R.drawable.arrow_up),"${weeklyForecastUiState.maxTemp}°C", themeColor.header2darkBlue87pre, themeColor.header2darkBlue87pre)
            VerticalDivider(color = themeColor.verticaldarkBlue24pre, modifier = Modifier.height(19.dp))
            MinMaxTemperature(painterResource(R.drawable.arrow_down),"${weeklyForecastUiState.minTemp}°C", themeColor.header2darkBlue87pre, themeColor.header2darkBlue87pre)
        }
    }
}