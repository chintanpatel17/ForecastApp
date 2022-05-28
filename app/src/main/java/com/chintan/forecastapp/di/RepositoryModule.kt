package com.chintan.forecastapp.di

import com.chintan.forecastapp.remote.RemoteHelper
import com.chintan.forecastapp.remote.service.GeocodingService
import com.chintan.forecastapp.repository.GeocodingRepository
import com.chintan.forecastapp.repository.impl.GeocodingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Singleton
    @Provides
    fun provideGeocodingRepository(
        geocodingService: GeocodingService,
        remoteHelper: RemoteHelper
    ): GeocodingRepository {
        return GeocodingRepositoryImpl(geocodingService, remoteHelper)
    }

}