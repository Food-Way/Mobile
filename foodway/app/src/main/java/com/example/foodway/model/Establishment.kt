package com.example.foodway.model

import java.util.UUID

data class Establishment(
    val idUser: UUID,
    val name: String,
    val email: String,
    val password: String,
    val profilePhoto: String,
    val typeUser: String,
    val culinaries: List<Culinary>,
    val description: String,
    val rate: Double,
    val qtdUpvotes: Int,
    val qtdComments: Int
) : TypeUser {
    override fun getUserType(): String {
        return "ESTABLISHMENT"
    }
}