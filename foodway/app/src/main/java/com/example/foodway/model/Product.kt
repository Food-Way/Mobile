package com.example.foodway.model

import java.util.UUID

data class Product(
    val idProduct: UUID,
    val name: String,
    val description: String,
    val value: Double
)
