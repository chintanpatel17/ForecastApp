package com.chintan.forecastapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<UiState> : ViewModel() {

    private val initialState: UiState by lazy { setInitialState() }
    abstract fun setInitialState(): UiState

    private val uiStateData: MutableState<UiState> = mutableStateOf(initialState)
    val uiState: State<UiState> = uiStateData

    protected fun setUiState(newUiState: UiState) {
        uiStateData.value = newUiState
    }

}