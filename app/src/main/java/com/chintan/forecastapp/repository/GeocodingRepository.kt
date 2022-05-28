package com.chintan.forecastapp.repository

import com.chintan.forecastapp.model.GeoCodeDirect
import com.chintan.forecastapp.remote.Resource
import kotlinx.coroutines.flow.Flow

interface GeocodingRepository {

    suspend fun getGeoDirect(cityName: String): Flow<Resource<List<GeoCodeDirect>>>

}