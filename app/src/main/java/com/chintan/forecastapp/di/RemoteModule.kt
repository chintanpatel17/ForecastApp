package com.chintan.forecastapp.di

import com.chintan.forecastapp.BuildConfig
import com.chintan.forecastapp.remote.service.ForecastService
import com.chintan.forecastapp.remote.service.GeocodingService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
/*
    @Singleton
    @Provides
    fun provideInternetHelper(@ApplicationContext context: Context): InternetHelper =
        InternetHelper(context)*/

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun provideHttpInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val url = request.url.newBuilder()
                .addQueryParameter("appid", BuildConfig.FORECAST_APP_ID)
                .build()
            return@Interceptor chain.proceed(request.newBuilder().url(url).build())
        }
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }

    @Singleton
    @Provides
    @Named("GEO")
    fun providesGeoRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(BuildConfig.GEO_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @Named("FORECAST")
    fun providesForecastRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(BuildConfig.FORECAST_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesGeocodingService(@Named("GEO") retrofit: Retrofit): GeocodingService {
        return retrofit.create(GeocodingService::class.java)
    }

    @Singleton
    @Provides
    fun providesForecastService(@Named("FORECAST") retrofit: Retrofit): ForecastService {
        return retrofit.create(ForecastService::class.java)
    }
}