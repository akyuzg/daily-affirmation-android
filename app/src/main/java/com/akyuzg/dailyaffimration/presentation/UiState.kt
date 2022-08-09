package com.akyuzg.dailyaffimration.presentation

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Error(var message: String?) : UiState<Nothing>()
    data class Data<T>(var data: T) : UiState<T>()
}