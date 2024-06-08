package com.example.foodway.domain.profile.establishment.model

import java.util.UUID

data class PostComment(
    val idUser: UUID,
    val idEstablishment: UUID,
    val comment: String,
    val userPhoto: String,
    val userName: String,
    val typeUser: String,
)