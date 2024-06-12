package com.example.foodway.domain.searchUser.model

import com.example.foodway.domain.model.UserType

data class SearchedEstablishment(
    val idEstablishment: String,
    val name: String,
    val typeUser: UserType,
    val culinary: String,
    val generalRate: Double,
    val bio: String,
    val upvote: Int,
    val photo: String,
    val lat: String,
    val lng: String,
    val qtdComments: Int,
    val isFavorite: Boolean
)