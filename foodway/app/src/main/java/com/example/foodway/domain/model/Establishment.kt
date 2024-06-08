package com.example.foodway.domain.model

import java.util.UUID

data class Establishment(
    val idEstablishment: UUID,
    val name: String,
    val email: String,
    val password: String,
    val profilePhoto: String,
    val typeUser: String,
    val culinaries: List<Culinary>,
    val rate: Double,
    val qtdUpvotes: Int,
    val qtdComments: Int,
    val description: String,
    val isFavorite: Boolean
)