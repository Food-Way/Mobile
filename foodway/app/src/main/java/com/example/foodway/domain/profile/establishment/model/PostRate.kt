package com.example.foodway.domain.profile.establishment.model

import java.util.UUID

data class PostRate(
//    @SerializedName("idCustomer")
    val idCustomer: UUID,
//    @SerializedName("idEstablishment")
    val idEstablishment: UUID,
//    @SerializedName("rates")
    val rates: List<Rate>
)
