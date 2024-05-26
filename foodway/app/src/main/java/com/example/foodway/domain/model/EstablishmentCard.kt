package com.example.foodway.domain.model

import java.util.UUID

data class EstablishmentCard(
//    @SerializedName("idEstablishment")
    val idEstablishment: UUID,

//    @SerializedName("establishmentName")
    val establishmentName: String,

//    @SerializedName("photo")
    val photo: String
)