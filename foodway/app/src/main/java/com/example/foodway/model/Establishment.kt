package com.example.foodway.model

import java.util.UUID

data class Establishment(
    override val idUser: UUID,
    override val name: String,
    override val email: String,
    override val password: String,
    override val profilePhoto: String,
    override val typeUser: String,
    override val culinaries: List<Culinary>,
    val description: String,
    val rate: Double,
    val qtdUpvotes: Int,
    val qtdComments: Int
) : User(idUser, name, email, password, typeUser, profilePhoto, culinaries)