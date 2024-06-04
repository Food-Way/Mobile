package com.example.foodway.presentation

sealed interface MainScreenState {
    data object Loading : MainScreenState

    data class Success<T>(
        val data: T
    ) : MainScreenState

    data class Error(
        val message: String
    ) : MainScreenState
}