package com.example.foodway.domain.model

import java.util.UUID

data class Upvote(
    val idCustomer: UUID,
    val idEstablishment: UUID,
    val idComment: UUID
)
