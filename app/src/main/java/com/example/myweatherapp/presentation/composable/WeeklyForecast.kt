package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.presentation.viewmodel.state.WeeklyForecastUiState
import com.example.myweatherapp.ui.theme.ThemeColor
import com.example.myweatherapp.ui.theme.letterSpacing25
import com.example.myweatherapp.ui.theme.text20
import com.example.myweatherapp.ui.theme.urbanist

@Composable
fun WeeklyForecast(
    themeColor: ThemeColor,
    forecastStates: List<WeeklyForecastUiState>
){
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 32.dp)

    ) {
        Text(
            text = "Next 7 days",
            color = themeColor.HeaderDarkBlue,
            fontSize = text20,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W600,
            fontFamily = urbanist,
        )
        Spacer(Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = themeColor.boxBackgroundwhite70pre),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clip(RoundedCornerShape(24.dp))
                .border(width = 1.dp, color = themeColor.ButtonsdarkBlue8pre, shape = RoundedCornerShape(24.dp))
        ){
            for(forecast in 0..(forecastStates.size - 1)){
                WeeklyForecastItem(themeColor, weeklyForecastUiState = forecastStates[forecast])
                if (forecast != forecastStates.size - 1){
                    HorizontalDivider(color = themeColor.ButtonsdarkBlue8pre)
                }
            }
        }
    }
}