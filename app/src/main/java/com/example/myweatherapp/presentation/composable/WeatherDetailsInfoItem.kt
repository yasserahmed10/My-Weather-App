package com.example.myweatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.example.myweatherapp.ui.theme.ThemeColor
import com.example.myweatherapp.ui.theme.backgroundLightBlue
import com.example.myweatherapp.ui.theme.letterSpacing25
import com.example.myweatherapp.ui.theme.text14
import com.example.myweatherapp.ui.theme.text20
import com.example.myweatherapp.ui.theme.urbanist

@Composable
fun WeatherDetailsInfoItem(
    theme: ThemeColor,
    icon: Painter = painterResource(R.drawable.wind),
    value: String = "13 KM/h",
    name: String = "Wind"
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(108.dp)
            .clip(RoundedCornerShape(24.dp))
            .border(width = 1.dp, color = theme.ButtonsdarkBlue8pre, shape = RoundedCornerShape(24.dp))
            .background(color = theme.boxBackgroundwhite70pre, shape = RoundedCornerShape(24.dp))
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
        ){
            Icon(
                painter = icon,
                contentDescription = null,
                tint = backgroundLightBlue,
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = value,
                color = theme.header2darkBlue87pre,
                fontSize = text20,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )
            Text(
                text = name,
                color = theme.contentDarkBlue60pre,
                fontSize = text14,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                fontFamily = urbanist,
            )
        }
    }
}