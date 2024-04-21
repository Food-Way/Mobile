package com.example.foodway.viewModel

sealed interface MainScreenState {
    data object Loading: MainScreenState

    data class Success (
        val data: List<Any>
    ) : MainScreenState

    data class Error(
        val message: String
    ) : MainScreenState
}