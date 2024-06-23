package com.example.foodway.domain.profile.establishment.model

import com.example.foodway.domain.model.ETypeUser

data class PostComment(
    val idCustomer: String,
    val idEstablishment: String,
    val comment: String,
    val userPhoto: String,
    val userName: String,
    val typeUser: ETypeUser,
    val images: List<String> = emptyList()
)