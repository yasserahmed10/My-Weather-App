package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.presentation.viewmodel.state.HourlyForecastUiState
import com.example.myweatherapp.ui.theme.ThemeColor
import com.example.myweatherapp.ui.theme.letterSpacing25
import com.example.myweatherapp.ui.theme.text20
import com.example.myweatherapp.ui.theme.urbanist

@Composable
fun TodayForecast(
    theme: ThemeColor,
    forecastStates: List<HourlyForecastUiState>
){
    Column{
        Text(
            text = "Today",
            color = theme.header2darkBlue87pre,
            fontSize = text20,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W600,
            fontFamily = urbanist,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Spacer(Modifier.height(24.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(forecastStates) {
                TodayForeCastItem(theme,hourlyForecastUiState = it)
            }
        }
    }
}