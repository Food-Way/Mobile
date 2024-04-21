package com.example.foodway.model

data class ProfileEstablishment(
    val name: String,
    val description: String,
    val photo: String,
    val culinary: Culinary,
    val rate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,
    val comments: List<Comment>,
)
