package com.chintan.forecastapp.repository.impl

import com.chintan.forecastapp.model.GeoCodeDirect
import com.chintan.forecastapp.remote.RemoteHelper
import com.chintan.forecastapp.remote.Resource
import com.chintan.forecastapp.remote.service.GeocodingService
import com.chintan.forecastapp.repository.GeocodingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GeocodingRepositoryImpl @Inject constructor(
    private val geocodingService: GeocodingService,
    private val remoteHelper: RemoteHelper
) : GeocodingRepository {

    override suspend fun getGeoDirect(cityName: String): Flow<Resource<List<GeoCodeDirect>>> {
        return remoteHelper.call {
            geocodingService.getGeoDirect(cityName)
        }
    }

}