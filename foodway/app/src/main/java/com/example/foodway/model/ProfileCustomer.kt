package com.example.foodway.model

data class ProfileCustomer(
    val name: String,
    val bio: String,
    val photo: String,
    val level: Int,
    val xp: Double,
    val rate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,
    val recentEstablishment: List<Establishment>? = null,
    val favoriteEstablishment: List<Establishment>? = null
)
