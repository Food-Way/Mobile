package com.example.foodway.model

import java.util.UUID

data class Upvote(
    val idCustomer: UUID,
    val idEstablishment: UUID,
    val idComment: UUID
)
