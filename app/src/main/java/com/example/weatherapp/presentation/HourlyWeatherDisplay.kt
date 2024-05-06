package com.example.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White) {

    Column(
        modifier= modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){

        Text(
            text = weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm")),
            color = textColor
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription =null,
            colorFilter = ColorFilter.tint(textColor)
        )
        Text(
            text = "${weatherData.temperatureCelsius}°C",
            color = textColor
        )

    }

}