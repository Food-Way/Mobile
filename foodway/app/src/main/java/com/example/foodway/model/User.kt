package com.example.foodway.model

import java.util.UUID

sealed class User(
    open val idUser: UUID,
    open val name: String,
    open val email: String,
    open val password: String,
    open val typeUser: String,
    open val profilePhoto: String,
    open val culinaries: List<Culinary>
)