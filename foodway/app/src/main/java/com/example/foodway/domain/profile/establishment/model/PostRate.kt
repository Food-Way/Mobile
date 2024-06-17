package com.example.foodway.domain.profile.establishment.model

import java.util.UUID

data class PostRate(
    val idCustomer: UUID,
    val idEstablishment: UUID,
    val rates: List<Rate>
)
