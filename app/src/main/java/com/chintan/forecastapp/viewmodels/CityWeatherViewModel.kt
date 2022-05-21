package com.chintan.forecastapp.viewmodels


class CityWeatherViewModel : BaseViewModel<CityWeatherUiState>() {

    override fun setInitialState() = CityWeatherUiState.InitState




}

sealed class CityWeatherUiState {

    object InitState : CityWeatherUiState()


}