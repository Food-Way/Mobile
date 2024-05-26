package com.example.foodway.domain.establishmentMenu.model

import java.util.UUID

data class Product(
    val idProduct: UUID,
    val name: String,
    val description: String,
    val photo: String,
    val value: Double
)
