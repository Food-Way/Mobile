package com.example.foodway.domain.edit.establishment.model

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class GetProfileEstablishmentEdit(
    val idUser: UUID,
    val name: String,
    val establishmentName: String,
    val email: String,
    val description: String,
    val phone: String,
    val profilePhoto: String,
    @SerializedName("address")
    val address: Address
)

data class Address(
    val cep: String
)