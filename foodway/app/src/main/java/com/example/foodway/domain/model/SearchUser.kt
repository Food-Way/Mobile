package com.example.foodway.domain.model

data class SearchUser(
    val customers: List<Customer>,
    val establishments: List<Establishment>,
    val favorites: List<Favorite>
)
