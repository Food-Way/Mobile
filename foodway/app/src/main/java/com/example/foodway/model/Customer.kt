package com.example.foodway.model

import java.util.UUID

data class Customer(
    val idUser: UUID,
    val name: String,
    val email: String,
    val password: String,
    val profilePhoto: String,
    val typeUser: String,
    val culinaries: List<Culinary>,
    val bio: String,
    val rate: Double,
    val qtdUpvotes: Int,
    val qtdComments: Int,
    val level: Int,
    val xp: Double
) : TypeUser {
    override fun getUserType(): String {
        return "CLIENT"
    }
}