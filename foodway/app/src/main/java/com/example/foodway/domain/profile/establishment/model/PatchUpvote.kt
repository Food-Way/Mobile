package com.example.foodway.domain.profile.establishment.model

import java.util.UUID

data class PatchUpvote (
    val idCustomer: UUID,
    val idEstablishment: UUID,
    val idComment: UUID
)