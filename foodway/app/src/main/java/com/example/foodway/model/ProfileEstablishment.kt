package com.example.foodway.model

data class ProfileEstablishment(
    val establishmentName: String,
    val description: String,
    val photo: String,
    val profileHeaderImg: String,
    val culinary: String,
    val rate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,
    val comments: List<Comment>,
)
