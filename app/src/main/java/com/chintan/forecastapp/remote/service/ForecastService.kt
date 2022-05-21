package com.chintan.forecastapp.remote.service

import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("hourly")
    fun getHourlyForecastData(@Query("lat") latitude: Double, @Query("lon") lon: Double)

}