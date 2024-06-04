package com.example.foodway.domain.profile.establishment.model

import com.example.foodway.domain.model.Comment

data class ProfileEstablishment(
    val establishmentName: String,
    val fantasyName: String,
    val responsible: String,
    val email: String,
    val description: String,
    val photo: String,
    val profileHeaderImg: String,
    val culinary: String,
    val rate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,
    val comments: List<Comment>,
)
