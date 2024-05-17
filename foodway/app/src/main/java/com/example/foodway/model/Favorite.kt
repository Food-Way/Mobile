package com.example.foodway.model

import java.util.UUID

data class Favorite(
    val idFavorite: Int,
    val idCustomer: UUID,
    val idEstablishment: UUID
)