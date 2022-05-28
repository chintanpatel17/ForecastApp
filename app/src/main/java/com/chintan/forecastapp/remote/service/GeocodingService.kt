package com.chintan.forecastapp.remote.service

import com.chintan.forecastapp.model.GeoCodeDirect
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {

    @GET("direct")
    suspend fun getGeoDirect(@Query("q") city: String): List<GeoCodeDirect>

}