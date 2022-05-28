package com.chintan.forecastapp.viewmodels

import androidx.lifecycle.viewModelScope
import com.chintan.forecastapp.remote.Resource
import com.chintan.forecastapp.repository.GeocodingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityWeatherViewModel @Inject constructor(private val geocodingRepository: GeocodingRepository) :
    BaseViewModel<CityWeatherUiState>() {


    override fun setInitialState() = CityWeatherUiState.InitState


    fun getGeoCodeDirect(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            geocodingRepository.getGeoDirect(cityName).collect {
                when (it) {
                    is Resource.Loading -> {

                    }
                    is Resource.Error -> {

                    }
                    is Resource.Success -> {

                    }
                }
            }
        }
    }


}

sealed class CityWeatherUiState {

    object InitState : CityWeatherUiState()


}