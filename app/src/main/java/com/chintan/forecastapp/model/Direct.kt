package com.chintan.forecastapp.model

import com.google.gson.annotations.SerializedName

data class Direct(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("state") val state: String,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
)
