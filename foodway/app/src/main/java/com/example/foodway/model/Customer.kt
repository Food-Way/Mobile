package com.example.foodway.model

import java.util.UUID

data class Customer(
    override val idUser: UUID,
    override val name: String,
    override val email: String,
    override val password: String,
    override val profilePhoto: String,
    override val typeUser: String,
    override val culinaries: List<Culinary>,
    val bio: String,
    val rate: Double,
    val qtdUpvotes: Int,
    val qtdComments: Int,
    val level: Int,
    val xp: Double
) : User(idUser, name, email, password, typeUser, profilePhoto, culinaries)
