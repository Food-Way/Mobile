package com.example.foodway.domain.searchUser.model

import com.example.foodway.domain.model.ETypeUser

data class SearchedEstablishment(
    val idEstablishment: String,
    val name: String,
    val typeUser: ETypeUser,
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