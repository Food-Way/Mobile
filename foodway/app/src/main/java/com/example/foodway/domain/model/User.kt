package com.example.foodway.domain.model

import java.util.UUID

data class User(
    val idUser: UUID,
    val name: String,
    val email: String,
    val password: String,
    val typeUser: String,
    val profilePhoto: String,
    val culinaries: List<Culinary>
)