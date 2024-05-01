package com.example.foodway.viewModel

sealed interface MainScreenState {
    data object Loading : MainScreenState

    data class Success<T>(
        val data: List<T>
    ) : MainScreenState

    data class SuccessSingle<T>(
        val data: T
    ) : MainScreenState

    data class Error(
        val message: String
    ) : MainScreenState
}