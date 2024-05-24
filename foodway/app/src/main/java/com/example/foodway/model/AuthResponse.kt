package com.example.foodway.model

import java.util.UUID

data class AuthResponse (
    val idUser: UUID,
    val typeUser: String,
)