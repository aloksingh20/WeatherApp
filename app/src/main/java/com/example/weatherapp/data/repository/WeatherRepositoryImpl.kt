package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mappers.toWeatherInfo
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.util.Resource
import com.example.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi:WeatherApi
):WeatherRepository {
    override suspend fun getWeatherData(lon: Double, lat: Double): Resource<WeatherInfo> {
        return try{
             Resource.Success(
                 data = weatherApi.getWeatherData(
                     lon = lon,
                     lat = lat
                 ).toWeatherInfo()
             )
        }
        catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.message?:"An unknown occurred.")
        }
    }
}