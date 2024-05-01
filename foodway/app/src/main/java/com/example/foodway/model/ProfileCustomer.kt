package com.example.foodway.model

data class ProfileCustomer(
    val name: String,
    val bio: String,
    val profilePhoto: String,
    val level: Int,
    val xp: Double,
    val profileRate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,
//    val recentEstablishment: List<Establishment>? = null,
//    val favoriteEstablishment: List<Establishment>? = null
)
