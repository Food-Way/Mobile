package com.example.foodway.domain.signIn.model

import java.util.UUID

data class AuthResponse (
    val idUser: UUID,
    val typeUser: String,
    val token: String,
    val photo: String,
    val name: String
)